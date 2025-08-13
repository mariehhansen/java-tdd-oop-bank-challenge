package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class BankManager {

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

    public boolean approveOverdraft(Account account, float amount) {
        if (account instanceof CurrentAccount && account.getBalance() - amount < 5000) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Account account = new CurrentAccount(1);
        account.deposit(100000);
        account.getTransactions();
        account.deposit(200);
        account.getTransactions();
        account.withdraw(50);
        account.getTransactions();
        System.out.println(account.toString());
    }
}
