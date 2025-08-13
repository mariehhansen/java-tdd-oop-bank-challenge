package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

abstract public class Account {

    private float balance;
    private final int accountId;
    private Map<Integer, Transaction> transactions; // <transactionId, Transaction>

    public Account(int accountNumber) {
        this.accountId = accountNumber;
        transactions = new HashMap<>();
    }

    public float getBalance() {
        return this.balance;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public Map<Integer, Transaction> getTransactions() {
        return this.transactions;
    }

    public void deposit(float amount) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = this.balance + amount;
        Transaction tr = new Transaction(dtFormatter(LocalDate.now()), amount, "credit");
        transactions.put(tr.getTransactionId(), tr);
    }

    public void withdraw(float amount) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = this.balance - amount;
        Transaction tr = new Transaction(dtFormatter(LocalDate.now()), amount, "debit");
        transactions.put(tr.getTransactionId(), tr);
    }

    private String dtFormatter(LocalDate date) {
        DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dtForm.format(date);
    }

    public String toString() {
        String str = "";
        str += String.format("%-15s || %-15s || %-15s || %s" , "date", "credit", "debit", "balance" );

        for (Map.Entry<Integer, Transaction> entry : this.transactions.entrySet()) {
            str += "\n";
            if (entry.getValue().getType().equals("credit")) {
                str += String.format("%-15s || %-15s || %-15s || %s" , entry.getValue().getTime(), entry.getValue().getAmount(), " ", this.balance);
            }
            else if (entry.getValue().getType().equals("debit")) {
                str += String.format("%-15s || %-15s || %-15s || %s" , entry.getValue().getTime(), " " , entry.getValue().getAmount() , this.balance);
            }
            else { break; }
        }

        return str;
    }
}
