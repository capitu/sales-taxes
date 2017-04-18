import java.math.BigDecimal;

public class TaxCalculator {

    public static BigDecimal importDuty = BigDecimal.valueOf(5);
    public static BigDecimal basicTax = BigDecimal.valueOf(10);
    public static BigDecimal roundFraction = BigDecimal.valueOf(0.05);

    public static BigDecimal calculateProductTax(Product product) {
        BigDecimal taxPercent = calculateTaxPercent(product);
        BigDecimal taxValue = product.getPrice().multiply(taxPercent).divide(BigDecimal.valueOf(100));
        return roundValue(taxValue);
    }

    private static BigDecimal calculateTaxPercent(Product product) {
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


    private static BigDecimal roundValue(BigDecimal val) {
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
