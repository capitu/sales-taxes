import java.math.BigDecimal;

public class ReceiptProduct {

    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public ReceiptProduct(Product product, int quantity, BigDecimal totalPrice) {
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return this.getQuantity() + " " + this.getProduct().getName() + ": " + this.getTotalPrice();
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

}
