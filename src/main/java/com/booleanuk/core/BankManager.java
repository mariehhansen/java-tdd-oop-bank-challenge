package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankManager {

    // private List<Account> accounts; // needed? each branch has the list
    private List<Branch> branches;

    public BankManager() {
        this.branches = new ArrayList<>();
    }

    public void addBranch(Branch b) {
        this.branches.add(b);
    }

    public List<Branch> getBranches() {
        return this.branches;
    }

    public List<Account> getAccounts(Branch branch) {
        for (Branch b : branches) {
            if (b.equals(branch) && !branch.getAccounts().isEmpty()) {
                return branch.getAccounts();
            }
            else {
                System.out.println("Branch does not have any accounts.");
            }
        }
        return null;
    }
}
