import Billing.BillingLogic;
import UserInterface.UI;
import BillPrinting.PrintOption;
import java.awt.Frame;

import java.applet.Applet;


public class Main {
 public static void main(String[] args) {
  // Create an instance of the UI applet
      UI applet = new UI();

  // Initialize the applet
  applet.init();

  // Start the applet
  applet.start();

  // Create a frame to display the applet
  Frame frame = new Frame("Billing System Applet");

  // Add the applet to the frame
  frame.add(applet);

  // Set the size of the frame
  frame.setSize(1400, 800);

  // Make the frame visible
  frame.setVisible(true);


 }
}
