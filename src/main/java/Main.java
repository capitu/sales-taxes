import product.Product;
import receipt.Receipt;
import receipt.ReceiptFactory;
import utils.PriceCalculator;
import utils.ReceiptPrinter;
import utils.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator(BigDecimal.valueOf(5), BigDecimal.valueOf(10), BigDecimal.valueOf(0.05));
        PriceCalculator priceCalculator = new PriceCalculator(taxCalculator);
        ReceiptFactory receiptFactory = new ReceiptFactory(priceCalculator, taxCalculator);
        ReceiptPrinter receiptPrinter = new ReceiptPrinter(System.out);

        ArrayList<Product> basketNotImportedItems = new ArrayList<Product>();
        basketNotImportedItems.add(new Product("book", Product.ProductType.BOOK, false, 12.49));
        basketNotImportedItems.add(new Product("music CD", Product.ProductType.OTHER, false, 14.99));
        basketNotImportedItems.add(new Product("chocolate bar", Product.ProductType.FOOD, false, 0.85));
        Receipt receiptNotImportedItems = receiptFactory.create(basketNotImportedItems);
        receiptPrinter.print(receiptNotImportedItems);

        ArrayList<Product> basketImportedItems = new ArrayList<Product>();
        basketImportedItems.add(new Product("box of chocolates", Product.ProductType.FOOD, true, 10.00));
        basketImportedItems.add(new Product("bottle of perfume", Product.ProductType.OTHER, true, 47.50));
        Receipt receiptImportedItems = receiptFactory.create(basketImportedItems);
        receiptPrinter.print(receiptImportedItems);

        ArrayList<Product> basketMixedItems = new ArrayList<Product>();
        basketMixedItems.add(new Product("bottle of perfume", Product.ProductType.OTHER, true, 27.99));
        basketMixedItems.add(new Product("bottle of perfume", Product.ProductType.OTHER, false, 18.99));
        basketMixedItems.add(new Product("packet of headache pills", Product.ProductType.MEDICAL, false, 9.75));
        basketMixedItems.add(new Product("box of chocolates ", Product.ProductType.FOOD, true, 11.25));
        Receipt receiptMixedItems = receiptFactory.create(basketMixedItems);
        receiptPrinter.print(receiptMixedItems);

    }
}
