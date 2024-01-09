package com.herbalife.lab04;

import java.time.LocalDateTime;
import java.util.ArrayList;
import static com.herbalife.lab04.AccountConstants.*;
import static com.herbalife.lab04.TransactionType.*;

public class Account {

    private long accountNumber;
    private double balance;
    private int withdrawCount;
    private ArrayList<Transaction> transactions;
    private ArrayList<TransactionRecord> transactionRecords;

    public Account(long accountNumber, double balance) {
        if (balance < 10000) {
            throw new RuntimeException(MINIMUM_BALANCE);
        }
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.transactionRecords = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getNumberOfFreeWithdraw() {
        return 3;
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction txn = new Transaction(accountNumber, amount, CREDIT);
        this.transactions.add(txn);

        TransactionRecord transactionRecord = new TransactionRecord(accountNumber, amount, CREDIT, LocalDateTime.now());
        this.transactionRecords.add(transactionRecord);
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            throw new RuntimeException(INSUFFICIENT_BALANCE);
        }
        withdrawCount++;
        balance -= amount;
        Transaction txn = new Transaction(accountNumber, amount, DEBIT);
        this.transactions.add(txn);
        TransactionRecord transactionRecord = new TransactionRecord(accountNumber, amount, DEBIT, LocalDateTime.now());
        this.transactionRecords.add(transactionRecord);
        if (withdrawCount > getNumberOfFreeWithdraw()) {
            double fee = amount * 0.005;
            balance -= fee;
            Transaction feeTxn = new Transaction(accountNumber, amount, DEBIT_FEE);
            this.transactions.add(feeTxn);
            TransactionRecord feeTransactionRecord = new TransactionRecord(accountNumber, amount, DEBIT_FEE, LocalDateTime.now());
            this.transactionRecords.add(feeTransactionRecord);
        }
    }


    public String printStatement() {
        StringBuilder builder = new StringBuilder("");
//        for (Transaction txn : transactions) {
//            builder.append(txn);
//            builder.append("\n");
//        }
        for (TransactionRecord txn : transactionRecords) {
            builder.append(txn);
            builder.append("\n");
        }
        return builder.toString();
    }
}
