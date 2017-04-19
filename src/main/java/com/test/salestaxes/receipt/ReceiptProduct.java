package com.test.salestaxes.receipt;

import java.math.BigDecimal;

public class ReceiptProduct {

    private String name;
    private boolean imported;
    private int quantity;
    private BigDecimal totalPrice;

    public ReceiptProduct(String name, boolean imported, int quantity, BigDecimal totalPrice) {
        this.name = name;
        this.imported = imported;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getName() {
        return name;
    }

    public boolean isImported() {
        return imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

}
