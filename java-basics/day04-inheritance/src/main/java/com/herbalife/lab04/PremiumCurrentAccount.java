package com.herbalife.lab04;

public class PremiumCurrentAccount extends Account {

    public PremiumCurrentAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    public int getNumberOfFreeWithdraw() {
        return 100;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 1000000) {
            throw new RuntimeException(AccountConstants.WITHDRAW_LIMIT_1M);
        }
        super.withdraw(amount);
    }
}
