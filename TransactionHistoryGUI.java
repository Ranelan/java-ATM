package javaatm;

import javax.swing.*;

public class TransactionHistoryGUI {

    public static void showHistory(User user, JTextArea transactionArea) {
        StringBuilder history = new StringBuilder();
        if (user.getTransactionHistory().isEmpty()) {
            history.append("No transactions available.\n");
        } else {
            for (String transaction : user.getTransactionHistory()) {
                history.append(transaction).append("\n");
            }
        }
        history.append("Current Balance: R").append(user.getBalance()).append("\n");
        transactionArea.setText(history.toString());
    }
}
