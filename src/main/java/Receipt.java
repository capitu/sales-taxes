import java.math.BigDecimal;
import java.util.ArrayList;

public class Receipt {

    public ArrayList<ReceiptProduct> receiptProducts;
    public BigDecimal totalPrice;
    public BigDecimal totalTax;

    public Receipt(ArrayList<ReceiptProduct> receiptProducts, BigDecimal totalPrice, BigDecimal totalTax) {
        this.receiptProducts = receiptProducts;
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
    }

}
