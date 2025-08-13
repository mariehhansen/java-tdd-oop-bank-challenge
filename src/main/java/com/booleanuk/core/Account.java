package com.booleanuk.core;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

abstract public class Account {

    private float balance;
    private final int accountId;
    private Map<Integer, Transaction> transactions; // <transactionId, Transaction>
    private BankManager bm;

    public Account(int accountNumber) {
        this.accountId = accountNumber;
        transactions = new HashMap<>();
        this.bm = new BankManager();
    }

    public float getBalance() {
        return this.balance;
    }

    public int getAccountId() {
        return this.accountId;
    }

    public Map<Integer, Transaction> getTransactions() {
        for (Map.Entry<Integer, Transaction> entry : this.transactions.entrySet()) {
            System.out.println(entry.getValue().getAmount());
        }
        return this.transactions;
    }

    public void deposit(float amount) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance += amount;
        Transaction tr = new Transaction(dtFormatter(LocalDate.now()), amount, "credit");
        this.transactions.put(tr.getTransactionId(), tr);
    }

    public void withdraw(float amount) {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (amount > this.balance && this.bm.approveOverdraft(this, amount)) {
            this.balance -= amount;
        }
        else if (amount > this.getBalance() && this.bm.approveOverdraft(this, amount)) {
            System.out.println("Not sufficient funds.");
            return;
        }
        this.balance -= amount;
        Transaction tr = new Transaction(dtFormatter(LocalDate.now()), amount, "debit");
        transactions.put(tr.getTransactionId(), tr);
    }

    private String dtFormatter(LocalDate date) {
        DateTimeFormatter dtForm = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return dtForm.format(date);
    }

    public String getTransactionStatement() {
        float b = 0;
        String str = "";
        str += String.format("%-15s || %-15s || %-15s || %s" , "date", "credit", "debit", "balance" );
        str += "\n";
        str += String.format("%-15s || %-15s || %-15s || %s" , "-----------", "-----------", "-----------", "-----------" );

        for (Map.Entry<Integer, Transaction> entry : this.transactions.entrySet()) {
            str += "\n";
            if (entry.getValue().getType().equals("credit")) {
                b += entry.getValue().getAmount();
                str += String.format("%-15s || %-15s || %-15s || %s" , entry.getValue().getTime(), entry.getValue().getAmount(), " ", b);
            }
            else if (entry.getValue().getType().equals("debit")) {
                b -= entry.getValue().getAmount();
                str += String.format("%-15s || %-15s || %-15s || %s" , entry.getValue().getTime(), " " , entry.getValue().getAmount() , b);
            }
            else { break; }
        }

        return str;
    }
}
