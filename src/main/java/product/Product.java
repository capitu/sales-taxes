package product;

import java.math.BigDecimal;

public class Product {

    private String name;
    private ProductType type;
    private boolean imported;
    private BigDecimal price;

    public Product(String name, ProductType type, boolean imported, double price) {
        this.name = name;
        this.type = type;
        this.imported = imported;
        this.price = BigDecimal.valueOf(price);
    }

    public String getProductId() {
        return this.getName() + this.getType() + this.isImported() + this.getPrice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static enum ProductType {

        BOOK, FOOD, MEDICAL, OTHER

    }
}
