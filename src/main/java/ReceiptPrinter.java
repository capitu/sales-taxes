public class ReceiptPrinter {

    public static void print(Receipt receipt) {
        for (ReceiptProduct singleProduct : receipt.receiptProducts) {
            System.out.println(singleProduct);
        }

        System.out.println("Sales Taxes: " + receipt.totalTax);
        System.out.println("Total: " + receipt.totalPrice);

    }

}
