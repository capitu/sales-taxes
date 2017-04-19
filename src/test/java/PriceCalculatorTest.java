import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import product.Product;
import utils.PriceCalculator;
import utils.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PriceCalculatorTest {
    private TaxCalculator taxCalculator;
    private PriceCalculator priceCalculator;

    @Before
    public void setUp() {
        taxCalculator = new TaxCalculator(BigDecimal.valueOf(5), BigDecimal.valueOf(10), BigDecimal.valueOf(0.05));
        priceCalculator = new PriceCalculator(taxCalculator);
    }

    @Test
    public void testNotImportedProductDoesNotChangeItsPrice() {

        Product product = new Product("book", Product.ProductType.BOOK, false, 12.49);
        Assert.assertTrue(BigDecimal.valueOf(12.49).compareTo(priceCalculator.calculate(product)) == 0);
    }

    @Test
    public void testTotalAmountOfBasketOfNotImportedProducts() {

        List<Product> basketNotImportedItems = new ArrayList<Product>();
        basketNotImportedItems.add(new Product("book", Product.ProductType.BOOK, false, 12.49));
        basketNotImportedItems.add(new Product("music CD", Product.ProductType.OTHER, false, 14.99));
        basketNotImportedItems.add(new Product("chocolate bar", Product.ProductType.FOOD, false, 0.85));
        Assert.assertTrue(BigDecimal.valueOf(29.83).compareTo(priceCalculator.calculate(basketNotImportedItems)) == 0);
    }

    @Test
    public void testImportedProductChangesItsPrice() {

        Product importedProduct = new Product("box of chocolates", Product.ProductType.FOOD, true, 11.25);
        Assert.assertTrue(BigDecimal.valueOf(11.85).compareTo(priceCalculator.calculate(importedProduct)) == 0);
    }

    @Test
    public void testTotalAmountOfBasketOfImportedProducts() {

        ArrayList<Product> importedProducts = new ArrayList<Product>();
        importedProducts.add(new Product("box of chocolates", Product.ProductType.FOOD, true, 10.00));
        importedProducts.add(new Product("bottle of perfume", Product.ProductType.OTHER, true, 47.50));
        Assert.assertTrue(BigDecimal.valueOf(65.15).compareTo(priceCalculator.calculate(importedProducts)) == 0);
    }

}
