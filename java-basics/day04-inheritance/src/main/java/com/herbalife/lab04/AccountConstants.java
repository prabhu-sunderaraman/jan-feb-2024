package com.herbalife.lab04;

//The interfaces in C# start with letter I
//In Java, you don't have that convention
public interface AccountConstants {
    //In interfaces, the variables are public, static and final by default
    String MINIMUM_BALANCE = "Balance should be > 10000";
    String INSUFFICIENT_BALANCE = "Insufficient balance";
    String WITHDRAW_LIMIT_100K = "Withdraw limit is 100K only";
    String WITHDRAW_LIMIT_1M = "Withdraw limit is 1M only";
}
