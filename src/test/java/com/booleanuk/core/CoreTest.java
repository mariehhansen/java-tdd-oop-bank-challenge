package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}
