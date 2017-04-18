import java.math.BigDecimal;
import java.util.ArrayList;

public class ReceiptFactory {

    private static TaxCalculator taxCalculator = new TaxCalculator(BigDecimal.valueOf(5), BigDecimal.valueOf(10), BigDecimal.valueOf(0.05));
    private static PriceCalculator priceCalculator = new PriceCalculator(taxCalculator);


    public static Receipt create(ArrayList<Product> products) {
        BigDecimal totalPrice = priceCalculator.calculate(products);
        BigDecimal totalTax = taxCalculator.calculate(products);
        Receipt receipt = new Receipt(products, totalPrice, totalTax);
        return receipt;
    }
}
