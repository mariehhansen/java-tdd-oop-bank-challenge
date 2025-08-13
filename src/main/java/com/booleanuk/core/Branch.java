package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private List<Account> accounts;

    public Branch() {
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }
}
