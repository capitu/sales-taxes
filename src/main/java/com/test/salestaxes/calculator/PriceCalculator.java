package com.test.salestaxes.calculator;

import com.test.salestaxes.product.Product;

import java.math.BigDecimal;
import java.util.List;

public class PriceCalculator {

    private TaxCalculator taxCalculator;

    public PriceCalculator(TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
    }

    public BigDecimal calculate(List<Product> products) {
        BigDecimal totalPrice = BigDecimal.valueOf(0.0);
        for (Product p : products) {
            totalPrice = totalPrice.add(calculate(p));
        }
        return totalPrice;
    }

    public BigDecimal calculate(Product product) {
        BigDecimal tax = (taxCalculator.calculate(product));
        BigDecimal totalPrice = product.getPrice().add(tax);
        return totalPrice;
    }

    public BigDecimal calculate(Product product, int quantity) {
        return BigDecimal.valueOf(quantity).multiply(calculate(product));
    }

}
