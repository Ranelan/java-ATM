package javaatm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaATMGUI {

    private static User currentUser;
    private JFrame frame;
    private JTextArea transactionArea;
    private JLabel balanceLabel;

    public JavaATMGUI() {
        frame = new JFrame("ATM System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());

       
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        JLabel userIdLabel = new JLabel("User ID: ");
        JTextField userIdField = new JTextField();
        JLabel pinLabel = new JLabel("PIN: ");
        JPasswordField pinField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(userIdLabel);
        loginPanel.add(userIdField);
        loginPanel.add(pinLabel);
        loginPanel.add(pinField);
        loginPanel.add(new JLabel());
        loginPanel.add(loginButton);

        
        transactionArea = new JTextArea();
        transactionArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(transactionArea);

       
        balanceLabel = new JLabel("Balance: R0.00", SwingConstants.CENTER);

        
        JPanel buttonPanel = new JPanel();
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton transferButton = new JButton("Transfer");
        JButton historyButton = new JButton("Transaction History");
        JButton logoutButton = new JButton("Quit");

        buttonPanel.add(withdrawButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(transferButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(logoutButton);

       
        panel.add(loginPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(balanceLabel, BorderLayout.SOUTH);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);

        // Action Listeners
        loginButton.addActionListener(e -> {
            int userId = Integer.parseInt(userIdField.getText());
            int pin = Integer.parseInt(new String(pinField.getPassword()));
            currentUser = new User(userId, pin);
            if (currentUser.authenticateUser()) {
                JOptionPane.showMessageDialog(frame, "Login successful!");
                updateBalanceLabel();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid User ID or PIN.");
            }
        });

        withdrawButton.addActionListener(e -> {
            WithdrawGUI.withdraw(currentUser, frame);
            updateBalanceLabel();
        });

        depositButton.addActionListener(e -> {
            DepositGUI.deposit(currentUser, frame);
            updateBalanceLabel();
        });

        transferButton.addActionListener(e -> {
            TransferGUI.transfer(currentUser, frame);
            updateBalanceLabel();
        });

        historyButton.addActionListener(e -> {
            TransactionHistoryGUI.showHistory(currentUser, transactionArea);
        });

        logoutButton.addActionListener(e -> {
            currentUser = null;
            transactionArea.setText("");
            updateBalanceLabel();
            JOptionPane.showMessageDialog(frame, "Logged out successfully.");
        });
    }

    private void updateBalanceLabel() {
        if (currentUser != null) {
            balanceLabel.setText("Balance: R" + currentUser.getBalance());
        } else {
            balanceLabel.setText("Balance: R0.00");
        }
    }

    public static void main(String[] args) {
        new JavaATMGUI();
    }
}
