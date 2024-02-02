package com.herbalife.repository;

import com.herbalife.entity.Account;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AccountRepository implements PanacheRepositoryBase<Account, String> {

}
