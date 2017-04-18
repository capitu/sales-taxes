import java.math.BigDecimal;
import java.util.ArrayList;

public class ReceiptFactory {

    private TaxCalculator taxCalculator;
    private PriceCalculator priceCalculator;

    public ReceiptFactory(PriceCalculator priceCalculator, TaxCalculator taxCalculator) {
        this.taxCalculator = taxCalculator;
        this.priceCalculator = priceCalculator;
    }

    public Receipt create(ArrayList<Product> products) {
        ArrayList<ReceiptProduct> receiptProducts = new ArrayList<ReceiptProduct>();
        for (Product product: products) {
            ReceiptProduct receiptProduct = new ReceiptProduct(product, 1, priceCalculator.calculate(product));
            receiptProducts.add(receiptProduct);
        }
        BigDecimal totalPrice = priceCalculator.calculate(products);
        BigDecimal totalTax = taxCalculator.calculate(products);

        Receipt receipt = new Receipt(receiptProducts, totalPrice, totalTax);
        return receipt;
    }
}
