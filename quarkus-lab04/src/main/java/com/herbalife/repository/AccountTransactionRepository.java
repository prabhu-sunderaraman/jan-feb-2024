package com.herbalife.repository;

import com.herbalife.entity.AccountTransaction;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.stream.Stream;

@ApplicationScoped
public class AccountTransactionRepository implements PanacheRepositoryBase<AccountTransaction, Integer> {

    public Stream<AccountTransaction> findByAccountNumber(String accountNumber) {
        return this
                .find("account.accountNumber", accountNumber)
                .list()
                .stream();
    }
}
