import java.io.PrintStream;

public class ReceiptPrinter {

    public static void print(Receipt receipt, PrintStream printStream) {

        for (ReceiptProduct singleProduct : receipt.receiptProducts) {
            printStream.println(getSingleProductPrintLine(singleProduct));
        }

        printStream.println("Sales Taxes: " + receipt.totalTax);
        printStream.println("Total: " + receipt.totalPrice);

    }

    public static String getSingleProductPrintLine(ReceiptProduct singleProduct) {
        return singleProduct.getQuantity() + " " + (singleProduct.isImported() ? "imported " : "") + singleProduct.getName() + ": " + singleProduct.getTotalPrice();
    }

}
