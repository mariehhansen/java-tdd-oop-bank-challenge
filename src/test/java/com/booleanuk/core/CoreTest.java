package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class CoreTest {

    // ACCOUNT
    @Test
    public void shouldGetBalance() {
        Account a = new SavingsAccount(1);
        a.deposit(100.0f);
        a.withdraw(60.0f);
        Assertions.assertEquals(40.0f, a.getBalance());
    }

    @Test
    public void shouldGetAccountNumber() {
        Account a = new CurrentAccount(2);
        Assertions.assertEquals(2, a.getAccountId());
    }

    @Test
    public void shouldGetTransactions() {
        Account a = new SavingsAccount(1);
        a.deposit(100.0f);
        a.withdraw(50.0f);
        Map<String, Float> map = a.getTransactions();
        Assertions.assertEquals(2, map.size());
    }

    // BANK MANAGER
    @Test
    public void shouldHaveBranch() {
        BankManager bm = new BankManager();
        Branch b = new Branch();
        Account sa = new SavingsAccount(1);
        Account ca = new CurrentAccount(2);
        bm.addBranch(b);
        b.addAccount(sa);
        b.addAccount(ca);
        Assertions.assertEquals(List.of(sa, ca), bm.getAccounts(b));
    }

    @Test
    public void shouldGetBranches() {
        BankManager bm = new BankManager();
        Branch b1 = new Branch();
        Branch b2 = new Branch();
        bm.addBranch(b1);
        bm.addBranch(b2);
        Assertions.assertEquals(List.of(b1, b2), bm.getBranches());
    }
}
