package Billing;

import java.util.ArrayList;
import java.util.List;

public class BillingLogic {
    // ArrayList to store the items in the bill
    private static List<BillItem> billItems;

    public BillingLogic(){
        billItems = new ArrayList<BillItem>();
    }
    //method to add an item into the bill
    public void addItem(String itemName,String itemCode,int quantity,double price,double taxes){
        BillItem billItem = new BillItem(itemName,itemCode,quantity,price,taxes);
        billItems.add(billItem);
    }
    public static double calculateTotalBill() {
        double totalBill =0;
        for (BillItem item: billItems){
            totalBill+=item.getTotalAmount();

        }
        return totalBill;
    }
    public static double calculateTotalBillWithoutTaxes() {
        double totalBill =0;
        for (BillItem item: billItems){
            totalBill+=item.getTotalAmountWithoutTaxes();

        }
        return totalBill;
    }

    public List<BillItem> getBillItems() {
        return billItems;
    }

    public static class BillItem{
        private String itemName;
        private String itemCode;
        private int quantity;
        private double price;
        private double taxes;

        public BillItem(String itemName,String itemCode,int quantity,double price,double taxes) {
            this.itemName = itemName;
            this.itemCode = itemCode;
            this.quantity = quantity;
            this.price = price;
            this.taxes = taxes;
        }
        public double getTotalAmount(){
            double totalWithoutTaxes = quantity*price;
            return (totalWithoutTaxes + (totalWithoutTaxes*taxes));
        }
        public double getTotalAmountWithoutTaxes(){
            double totalWithoutTaxes = (quantity*price);

            return totalWithoutTaxes;
        }

        public double getPrice() {
            return price;
        }

        public double getQuantity() {
            return quantity;
        }

        public String getItemName() {
            return itemName;
        }
        public String getItemCode(){return itemCode;}
        public double getTaxes() {return taxes;}
    }
}
