import java.math.BigDecimal;
import java.util.List;

public class PriceCalculator {

    public static BigDecimal calculateReceiptTotalPrice(List<Product> products) {
        BigDecimal totalPrice = BigDecimal.valueOf(0.0);
        for (Product p : products) {
            totalPrice = totalPrice.add(calculateProductTotalPrice(p));
        }
        return totalPrice;
    }

    public static BigDecimal calculateReceiptTotalTax(List<Product> products) {
        BigDecimal totalTax = BigDecimal.valueOf(0.0);
        for (Product p : products) {
            totalTax = totalTax.add(TaxCalculator.calculateProductTax(p));
        }
        return totalTax;
    }

    public static BigDecimal calculateProductTotalPrice(Product product) {
        BigDecimal tax = (TaxCalculator.calculateProductTax(product));
        BigDecimal totalPrice = product.getPrice().add(tax);
        return totalPrice;
    }

}
