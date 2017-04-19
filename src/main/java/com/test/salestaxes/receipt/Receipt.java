package com.test.salestaxes.receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Receipt {

    public List<ReceiptProduct> receiptProducts;
    public BigDecimal totalPrice;
    public BigDecimal totalTax;

    public Receipt(ArrayList<ReceiptProduct> receiptProducts, BigDecimal totalPrice, BigDecimal totalTax) {
        this.receiptProducts = Collections.unmodifiableList(receiptProducts);
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
    }

}
