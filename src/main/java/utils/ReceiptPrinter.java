package utils;

import receipt.Receipt;
import receipt.ReceiptProduct;

import java.io.PrintStream;

public class ReceiptPrinter {

    private PrintStream printStream;

    public ReceiptPrinter(PrintStream printStream) {
        this.printStream = printStream;
    }

    private static String formatSingleProductLine(ReceiptProduct singleProduct) {
        return singleProduct.getQuantity() + " " + (singleProduct.isImported() ? "imported " : "") + singleProduct.getName() + ": " + singleProduct.getTotalPrice();
    }

    public void print(Receipt receipt) {

        for (ReceiptProduct singleProduct : receipt.receiptProducts) {
            printStream.println(formatSingleProductLine(singleProduct));
        }

        printStream.println("Sales Taxes: " + receipt.totalTax);
        printStream.println("Total: " + receipt.totalPrice);

    }

}
