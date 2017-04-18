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

    public static BigDecimal calculateProductTotalPrice(Product product) {
        BigDecimal tax = (TaxCalculator.calculate(product));
        BigDecimal totalPrice = product.getPrice().add(tax);
        return totalPrice;
    }

}
