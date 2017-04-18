import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Receipt {

    private ArrayList<Product> products;
    private BigDecimal totalPrice;
    private BigDecimal totalTax;

    public Receipt(ArrayList<Product> products, BigDecimal totalPrice, BigDecimal totalTax) {
        this.products = products;
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
    }

}
