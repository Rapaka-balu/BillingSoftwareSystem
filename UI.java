package UserInterface;
import BillPrinting.PrintOption;
import Billing.BillingLogic;
import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UI extends Applet implements ActionListener {
    private TextField itemCodeTextField;
    private Button getInfoButton, printBillButton;
    private TextArea itemCodeTextArea;
    private Label totalBillLabel, totalWithoutTaxesLabel;
    private BillingLogic billingLogic;

    // Database connection parameters
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public void init() {
        // Initialize UI components
        itemCodeTextField = new TextField(20);
        getInfoButton = new Button("Get Info");
        printBillButton = new Button("Print Bill");
        itemCodeTextArea = new TextArea(10, 20);
        itemCodeTextArea.setEditable(false); // Make text area read-only
        totalBillLabel = new Label("Total Bill:");
        totalWithoutTaxesLabel = new Label("Total Without Taxes:");

        // Add components to the applet
        add(new Label("Item Code:"));
        add(itemCodeTextField);
        add(getInfoButton);
        add(printBillButton);
        add(new Label("Item Codes:"));
        add(itemCodeTextArea);
        add(totalBillLabel);
        add(totalWithoutTaxesLabel);

        // Register action listeners for buttons
        getInfoButton.addActionListener(this);
        printBillButton.addActionListener(this);

        // Initialize BillingLogic
        billingLogic = new BillingLogic();

        // Fetch item codes and populate text area
        fetchItemCodes();
    }

    public void actionPerformed(ActionEvent e) {
        // Handle button click events
        if (e.getSource() == getInfoButton) {
            // This section will be replaced with database integration logic
            // For now, let's assume the details are obtained from the database
            // Get item details from the database based on item code
            // Simulated item details
            String itemCode = itemCodeTextField.getText().trim();
            String itemName = "OnePlus"; // Simulated item name
            int quantity = 4; // Simulated quantity
            double price = 24999.0; // Simulated price
            double taxes = 0.18; // Simulated taxes

            // Populate the UI fields with obtained item details
            // (This part will be replaced with actual database logic)
            itemCodeTextArea.append("Item Code: " + itemCode + "\n");
            itemCodeTextArea.append("Item Name: " + itemName + "\n");
            itemCodeTextArea.append("Quantity: " + quantity + "\n");
            itemCodeTextArea.append("Price: " + price + "\n");
            itemCodeTextArea.append("Taxes: " + taxes + "\n");
        } else if (e.getSource() == printBillButton) {
            // Generate bill and print it
            new PrintOption();
        }
    }

    private void fetchItemCodes() {
        // Clear existing item codes
        itemCodeTextArea.setText("");

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Create and execute SQL query to fetch item codes
            String sqlQuery = "SELECT item_code FROM items";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                // Process the result set
                while (resultSet.next()) {
                    String itemCode = resultSet.getString("item_code");
                    // Append item code to text area
                    itemCodeTextArea.append(itemCode + "\n");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle any SQL exceptions
        }
    }

    private void generateAndPrintBill() {
        // This method should remain the same as before
        // It calculates and prints the bill using BillingLogic methods
        // I assume you have already implemented this method
    }
}
