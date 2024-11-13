package javaatm;

import java.util.ArrayList;

public class User {
    private int userId;
    private int userPin;
    private double balance;
    private ArrayList<String> transactionHistory;

    public User(int userId, int userPin) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public boolean authenticateUser() {
        return userId == 1234 && userPin == 1234;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<String> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(String transaction) {
        transactionHistory.add(transaction);
    }
}
