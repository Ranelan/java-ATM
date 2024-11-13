package javaatm;

import javax.swing.*;

public class TransferGUI {

    public static void transfer(User user, JFrame parentFrame) {
        String accountStr = JOptionPane.showInputDialog(parentFrame, "Enter account number to transfer to:");
        String amountStr = JOptionPane.showInputDialog(parentFrame, "Enter amount to transfer:");
        if (accountStr != null && amountStr != null) {
            int accountNumber = Integer.parseInt(accountStr);
            double amount = Double.parseDouble(amountStr);
            if (user.getBalance() >= amount) {
                User receiver = new User(accountNumber, 0); 
                user.setBalance(user.getBalance() - amount);
                receiver.setBalance(receiver.getBalance() + amount);
                user.addTransaction("Transferred R" + amount + " to account " + accountNumber);
                JOptionPane.showMessageDialog(parentFrame, "Transfer of R" + amount + " successful.");
            } else {
                JOptionPane.showMessageDialog(parentFrame, "Insufficient funds.");
            }
        }
    }
}
