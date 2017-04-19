package utils;

import product.Product;

import java.math.BigDecimal;
import java.util.List;

public class TaxCalculator {

    private BigDecimal importDuty;
    private BigDecimal basicTax;
    private BigDecimal roundFraction;

    public TaxCalculator(BigDecimal importDuty, BigDecimal basicTax, BigDecimal roundFraction) {
        this.importDuty = importDuty;
        this.basicTax = basicTax;
        this.roundFraction = roundFraction;
    }


    public BigDecimal calculate(List<Product> products) {
        BigDecimal totalTax = BigDecimal.valueOf(0.0);
        for (Product p : products) {
            totalTax = totalTax.add(calculate(p));
        }
        return totalTax;
    }

    public BigDecimal calculate(Product product) {
        BigDecimal taxPercent = calculateTaxPercent(product);
        BigDecimal taxValue = product.getPrice().multiply(taxPercent).divide(BigDecimal.valueOf(100));
        return roundValue(taxValue);
    }

    private BigDecimal calculateTaxPercent(Product product) {
        BigDecimal taxPercent = BigDecimal.valueOf(0.0);

        if (product.isImported()) {
            taxPercent = taxPercent.add(importDuty);
        }

        switch (product.getType()) {
            case OTHER:
                taxPercent = taxPercent.add(basicTax);
                break;
            default:
                break;
        }

        return taxPercent;
    }


    private BigDecimal roundValue(BigDecimal val) {
        BigDecimal result = val;
        boolean needToRoundUp = val.scale() > 2;
        if (needToRoundUp) {
            int divided = (val.divide(roundFraction)).intValue();
            if (val.remainder(roundFraction).doubleValue() != 0) {
                divided += 1;
            }
            result = BigDecimal.valueOf(divided).multiply(roundFraction);
        }
        return result;

    }
}
