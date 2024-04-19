
package BillPrinting;
import Billing.*;

public class PrintOption {
    // Method to print the bill information
    public void printBill(BillingLogic billingLogic) {
        // Example implementation: print bill to console
        System.out.println("********** Bill Information **********");
        System.out.println("Bill Number: " + generateBillNumber()); // Generate and print bill number
        System.out.println("------------------------------");

        // Print itemized list of purchased items with details
        System.out.println("Item\t\tQuantity\tPrice\t\tTotal");
        for (BillingLogic.BillItem item : billingLogic.getBillItems()) {
            System.out.println(item.getItemName() + "\t\t" +
                    item.getQuantity() + "\t\t₹" +
                    item.getPrice() + "\t\t₹" +
                    item.getTotalAmount());
        }

        System.out.println("Bill without Taxes: " + billingLogic.calculateTotalBillWithoutTaxes());
        System.out.println("------------------------------");
        System.out.println("Total Bill Amount: ₹" + billingLogic.calculateTotalBill()); // Print total bill amount
        System.out.println("**********************************");
    }

    // Method to generate a unique bill number (example implementation)
    private String generateBillNumber() {
        return "B" + System.currentTimeMillis(); // Example: "B" + current timestamp
    }
}
