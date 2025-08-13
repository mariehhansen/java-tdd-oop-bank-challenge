package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CoreTest {

    // BRANCH
    @Test
    void addAndGetAccount() {
        Account a = new SavingsAccount(1);
        Branch b = new Branch();
        b.addAccount(a);
        Assertions.assertEquals(List.of(a), b.getAccounts());
    }

    // ACCOUNT
    @Test
    public void getBalance() {
        Account a = new SavingsAccount(1);
        a.deposit(100.0f);
        a.withdraw(60.0f);
        Assertions.assertEquals(40.0f, a.getBalance());
    }

    @Test
    public void getAccountNumber() {
        Account a = new CurrentAccount(2);
        Assertions.assertEquals(2, a.getAccountId());
    }

    @Test
    public void getTransactionsAccount() {
        Account a = new SavingsAccount(1);
        a.deposit(100.0f);
        a.withdraw(50.0f);
        Map<Integer, Transaction> map = a.getTransactions();
        Assertions.assertEquals(2, map.size());
    }

    @Test
    void getAccountId() {
        Account a = new SavingsAccount(1);
        Assertions.assertEquals(1, a.getAccountId());
    }

    @Test
    void deposit() {
        Account a = new CurrentAccount(1);
        a.deposit(100);
        Assertions.assertEquals(100, a.getBalance());
    }

    @Test
    void withdraw() {
        Account a = new CurrentAccount(1);
        a.deposit(100);
        a.withdraw(1);
        Assertions.assertEquals(99, a.getBalance());
    }

    @Test
    void approveOverdraft() {
        BankManager bm = new BankManager();
        Account a = new CurrentAccount(1);
        a.deposit(100);
        Assertions.assertFalse(bm.approveOverdraft(a, 100000));
    }

    // BANK MANAGER
    @Test
    public void addBranch() {
        BankManager bm = new BankManager();
        Branch b = new Branch();
        Assertions.assertEquals(List.of(b), bm.getBranches());
    }

    @Test
    void getAccounts() {
        BankManager bm = new BankManager();
        Branch b = new Branch();
        Account a = new SavingsAccount(1);
        Assertions.assertEquals(List.of(a), bm.getAccounts(b));
    }

    // TRANSACTION
    @Test
    void getType() {
        Transaction tr = new Transaction("123", 123, "credit");
        Assertions.assertEquals("123", tr.getTime());
    }

    @Test
    void getAmount() {
        Transaction tr = new Transaction("123", 123, "credit");
        Assertions.assertEquals(123, tr.getAmount());

    }

    @Test
    void getTransactionId() {
        Transaction tr = new Transaction("123", 123, "credit");
        Assertions.assertEquals("credit", tr.getType());

    }
}
