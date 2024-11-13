package javaatm;

import javax.swing.*;

public class WithdrawGUI {

    public static void withdraw(User user, JFrame parentFrame) {
        String amountStr = JOptionPane.showInputDialog(parentFrame, "Enter amount to withdraw:");
        if (amountStr != null) {
            double amount = Double.parseDouble(amountStr);
            if (user.getBalance() >= amount) {
                user.setBalance(user.getBalance() - amount);
                user.addTransaction("Withdrawal of R" + amount);
                JOptionPane.showMessageDialog(parentFrame, "Withdrawal of R" + amount + " processed.");
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Insufficient funds.");
            }
        }
    }
}
