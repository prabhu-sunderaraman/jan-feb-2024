package com.herbalife.lab04;

public class CurrentAccount extends Account {

    public CurrentAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public int getNumberOfFreeWithdraw() {
        return 10;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 100000) {
            throw new RuntimeException(AccountConstants.WITHDRAW_LIMIT_100K);
        }
        super.withdraw(amount);
    }
}
