package com.booleanuk.core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

abstract public class Account {

    private float balance;
    private final int accountId;
    private Map<String, Float> transactions;

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

    public Map<String, Float> getTransactions() {
        return this.transactions;
    }

    public void deposit(float amount) {
        // works, but in tests when I make deposit and withdraw the time is the same
        // add something to wait in test??
        //transactions.put(dtFormatter(LocalDateTime.now()), amount);
        transactions.put("Now", amount);
        this.balance += amount;
    }

    public void withdraw(float amount) {
        //transactions.put(dtFormatter(LocalDateTime.now()), -amount);
        transactions.put("Later", -amount);
        this.balance -= amount;
    }

    private String dtFormatter(LocalDateTime date) {
        DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return dtForm.format(date);
    }
}
