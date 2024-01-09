package com.herbalife.lab04;

public class Lab04Main {
    public static void main(String[] args) {
        Account account = new Account(234098, 20000);
        account.deposit(10000);
        account.deposit(10000);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        account.withdraw(100);
        System.out.println("Balance of %s is %s".formatted(account.getBalance(), account.getAccountNumber()));
        System.out.println("======Account STATEMENT=====");
        System.out.println(account.printStatement());

        CurrentAccount currentAccount = new CurrentAccount(1234098, 200000);
        currentAccount.deposit(10000);
        currentAccount.deposit(10000);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        currentAccount.withdraw(100);
        System.out.println("Balance of %s is %s".formatted(account.getBalance(), account.getAccountNumber()));
        System.out.println("======Current Account STATEMENT=====");
        System.out.println(currentAccount.printStatement());

        PremiumCurrentAccount premiumCurrentAccount = new PremiumCurrentAccount(986986, 100000000);
        premiumCurrentAccount.deposit(100000);
        premiumCurrentAccount.deposit(100000);
        for(int i = 0; i < 102;i++) {
            premiumCurrentAccount.withdraw(100);
        }
        System.out.println("Balance of %s is %s".formatted(premiumCurrentAccount.getBalance(), premiumCurrentAccount.getAccountNumber()));
        System.out.println("======Premium Current Account STATEMENT=====");
        System.out.println(premiumCurrentAccount.printStatement());
    }
}
