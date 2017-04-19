import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.test.salestaxes.product.Product;
import com.test.salestaxes.calculator.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @Before
    public void setUp() {
        taxCalculator = new TaxCalculator(BigDecimal.valueOf(5), BigDecimal.valueOf(10), BigDecimal.valueOf(0.05));
    }

    @Test
    public void testNotImportedExemptProductHasNoTaxApplied() {
        Product product = new Product("chocolate bar", Product.ProductType.FOOD, false, 0.85);
        Assert.assertTrue(BigDecimal.valueOf(0).compareTo(taxCalculator.calculate(product)) == 0);
    }

    @Test
    public void testImportedFoodProductHasOnlyImportDutyTaxApplied() {
        Product product = new Product("box of chocolates", Product.ProductType.FOOD, true, 10.00);
        Assert.assertTrue(BigDecimal.valueOf(0.5).compareTo(taxCalculator.calculate(product)) == 0);
    }

    @Test
    public void testNotImportedNotExemptProductHasBasicTaxApplied() {
        Product product = new Product("music CD", Product.ProductType.OTHER, false, 14.99);
        Assert.assertTrue(BigDecimal.valueOf(1.50).compareTo(taxCalculator.calculate(product)) == 0);
    }

    @Test
    public void testImportedNotExemptProductHasBasicAndImportTaxesApplied() {
        Product product = new Product("bottle of perfume", Product.ProductType.OTHER, true, 27.99);
        Assert.assertTrue(BigDecimal.valueOf(4.2).compareTo(taxCalculator.calculate(product)) == 0);
    }

    @Test
    public void testTotalTaxAmountOfBasketOfNotImportedProducts() {
        List<Product> basketNotImportedItems = new ArrayList<Product>();
        basketNotImportedItems.add(new Product("book", Product.ProductType.BOOK, false, 12.49));
        basketNotImportedItems.add(new Product("music CD", Product.ProductType.OTHER, false, 14.99));
        basketNotImportedItems.add(new Product("chocolate bar", Product.ProductType.FOOD, false, 0.85));
        Assert.assertTrue(BigDecimal.valueOf(1.50).compareTo(taxCalculator.calculate(basketNotImportedItems)) == 0);
    }

    @Test
    public void testTotalTaxAmountOfBasketOfImportedProducts() {
        List<Product> basketImportedItems = new ArrayList<Product>();
        basketImportedItems.add(new Product("box of chocolates", Product.ProductType.FOOD, true, 10.00));
        basketImportedItems.add(new Product("bottle of perfume", Product.ProductType.OTHER, true, 47.50));
        Assert.assertTrue(BigDecimal.valueOf(7.65).compareTo(taxCalculator.calculate(basketImportedItems)) == 0);
    }
}
