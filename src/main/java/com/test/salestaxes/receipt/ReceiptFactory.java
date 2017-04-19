package com.test.salestaxes.receipt;

import com.test.salestaxes.product.Product;
import com.test.salestaxes.calculator.PriceCalculator;
import com.test.salestaxes.calculator.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ReceiptFactory {

    private TaxCalculator taxCalculator;
    private PriceCalculator priceCalculator;

    public ReceiptFactory(PriceCalculator priceCalculator, TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        this.priceCalculator = priceCalculator;
    }

    public Receipt create(ArrayList<Product> products) {
        ArrayList<ReceiptProduct> receiptProducts = createReceiptProductList(products);
        BigDecimal totalPrice = priceCalculator.calculate(products);
        BigDecimal totalTax = taxCalculator.calculate(products);

        Receipt receipt = new Receipt(receiptProducts, totalPrice, totalTax);
        return receipt;
    }

    private ArrayList<ReceiptProduct> createReceiptProductList(ArrayList<Product> products) {
        HashMap<String, Integer> productToQuantityMap = new HashMap<String, Integer>();
        for (Product product : products) {
            String productId = product.getProductId();
            if ((productToQuantityMap.get(productId) == null)) {
                productToQuantityMap.put(productId, 1);
            } else {
                productToQuantityMap.put(productId, (productToQuantityMap.get(productId) + 1));
            }
        }

        HashSet<String> productAlreadyAdded = new HashSet<String>();
        ArrayList<ReceiptProduct> receiptProducts = new ArrayList<ReceiptProduct>();
        for (Product product : products) {
            if (!productAlreadyAdded.contains(product.getProductId())) {
                int productQuantity = productToQuantityMap.get(product.getProductId());
                ReceiptProduct receiptProduct = new ReceiptProduct(product.getName(), product.isImported(), productQuantity, priceCalculator.calculate(product, productQuantity));
                receiptProducts.add(receiptProduct);
                productAlreadyAdded.add(product.getProductId());
            }

        }

        return receiptProducts;
    }
}
