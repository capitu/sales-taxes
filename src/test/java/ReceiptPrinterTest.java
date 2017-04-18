import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ReceiptPrinterTest {

    private ReceiptFactory receiptFactory;

    @Before
    public void setUp() {
        TaxCalculator taxCalculator = new TaxCalculator(BigDecimal.valueOf(5), BigDecimal.valueOf(10), BigDecimal.valueOf(0.05));
        PriceCalculator priceCalculator = new PriceCalculator(taxCalculator);
        receiptFactory = new ReceiptFactory(priceCalculator, taxCalculator);
    }

    @Test
    public void testPrintReceiptNotImportedProductsBasket() {
        ArrayList<Product> basketNotImportedItems = new ArrayList<Product>();
        basketNotImportedItems.add(new Product("book", ProductType.BOOK, false, 12.49));
        basketNotImportedItems.add(new Product("music CD", ProductType.OTHER, false, 14.99));
        basketNotImportedItems.add(new Product("chocolate bar", ProductType.FOOD, false, 0.85));
        Receipt receipt = receiptFactory.create(basketNotImportedItems);
        ReceiptPrinter.print(receipt, System.out);

    }

    @Test
    public void testPrintReceiptImportedproductsBasket() {
        ArrayList<Product> basketImportedItems = new ArrayList<Product>();
        basketImportedItems.add(new Product("box of chocolates", ProductType.FOOD, true, 10.00));
        basketImportedItems.add(new Product("bottle of perfume", ProductType.OTHER, true, 47.50));
        Receipt receipt = receiptFactory.create(basketImportedItems);
        ReceiptPrinter.print(receipt, System.out);
    }


    @Test
    public void testPrintReceiptMixedBasket() {
        ArrayList<Product> basketMixedItems = new ArrayList<Product>();
        basketMixedItems.add(new Product("bottle of perfume", ProductType.OTHER, true, 27.99));
        basketMixedItems.add(new Product("bottle of perfume", ProductType.OTHER, false, 18.99));
        basketMixedItems.add(new Product("packet of headache pills", ProductType.MEDICAL, false, 9.75));
        basketMixedItems.add(new Product("box of chocolates ", ProductType.FOOD, true, 11.25));
        Receipt receipt = receiptFactory.create(basketMixedItems);
        ReceiptPrinter.print(receipt, System.out);
    }

}
