import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculatorTest {

    @Test
    public void testNotImportedProductDoesNotChangeItsPrice() {

        Product product = new Product("book", ProductType.BOOK, false, 12.49);
        Assert.assertTrue(BigDecimal.valueOf(12.49).compareTo(PriceCalculator.calculateProductTotalPrice(product)) == 0);
    }

    @Test
    public void testTotalAmountOfBasketOfNotImportedProducts() {

        List<Product> basketNotImportedItems = new ArrayList<Product>();
        basketNotImportedItems.add(new Product("book", ProductType.BOOK, false, 12.49));
        basketNotImportedItems.add(new Product("music CD", ProductType.OTHER, false, 14.99));
        basketNotImportedItems.add(new Product("chocolate bar", ProductType.FOOD, false, 0.85));
        Assert.assertTrue(BigDecimal.valueOf(29.83).compareTo(PriceCalculator.calculateReceiptTotalPrice(basketNotImportedItems)) == 0);
    }

    @Test
    public void testImportedProductChangesItsPrice() {

        Product importedProduct = new Product("box of chocolates", ProductType.FOOD, true, 10.00);
        Assert.assertTrue(BigDecimal.valueOf(10.50).compareTo(PriceCalculator.calculateProductTotalPrice(importedProduct)) == 0);
    }

    @Test
    public void testTotalAmountOfBasketOfImportedProducts() {

        ArrayList<Product> importedProducts = new ArrayList<Product>();
        importedProducts.add(new Product("box of chocolates", ProductType.FOOD, true, 10.00));
        importedProducts.add(new Product("bottle of perfume", ProductType.OTHER, true, 47.50));
        Assert.assertTrue(BigDecimal.valueOf(65.15).compareTo(PriceCalculator.calculateReceiptTotalPrice(importedProducts)) == 0);
       }

}
