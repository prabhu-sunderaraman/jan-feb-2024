package com.herbalife.lab04;

import java.time.LocalDateTime;

public class Transaction {
    private long accountNumber;
    private double amount;
    private TransactionType type;
    private LocalDateTime dateTime;

    public Transaction(long accountNumber, double amount, TransactionType type) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
        this.dateTime = LocalDateTime.now();
    }

    public String toString() {
        return "accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", dateTime=" + dateTime;
    }
}
