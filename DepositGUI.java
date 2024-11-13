package javaatm;

import javax.swing.*;

public class DepositGUI {

    public static void deposit(User user, JFrame parentFrame) {
        String amountStr = JOptionPane.showInputDialog(parentFrame, "Enter amount to deposit:");
        if (amountStr != null) {
            double amount = Double.parseDouble(amountStr);
            user.setBalance(user.getBalance() + amount);
            user.addTransaction("Deposit of R" + amount);
            JOptionPane.showMessageDialog(parentFrame, "Deposit of R" + amount + " processed.");
        }
    }
}
