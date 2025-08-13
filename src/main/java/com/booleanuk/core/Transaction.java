package com.booleanuk.core;

public class Transaction {

    private String time;
    private float amount;
    private String type;
    private final int transactionId; // bad for testing ;(
    private static int nextTransactionId = 1;

    public Transaction(String time, float amount, String type) {
        this.time = time;
        this.amount = amount;
        this.type = type;
        this.transactionId = nextTransactionId++;
    }

    public String getType() {
        return this.type;
    }

    public float getAmount() {
        return this.amount;
    }

    public int getTransactionId() {
        return this.transactionId;
    }

    public String getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "";
    }
}
