package com.herbalife.service;

import com.herbalife.dto.AccountTransactionDto;
import com.herbalife.entity.Account;
import com.herbalife.entity.AccountTransaction;
import com.herbalife.repository.AccountRepository;
import com.herbalife.repository.AccountTransactionRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BankService {
    @Inject
    AccountRepository accountRepository;

    @Inject
    AccountTransactionRepository accountTransactionRepository;

    @Transactional
    public void deposit(String accountNumber, int amount, String operationType) {
        Optional<Account> optionalAccount = accountRepository.findByIdOptional(accountNumber);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.persist(account);
            createAccountTransaction(amount, operationType, account);
        } else {
            throw new RuntimeException("Account not found for account number: " + accountNumber);
        }
    }

    @Transactional
    public void withdraw(String accountNumber, int amount, String operationType) {
        Optional<Account> optionalAccount = accountRepository.findByIdOptional(accountNumber);
        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            if (account.getBalance() < amount) {
                throw new RuntimeException("Insufficient balance for account number: " + accountNumber + " to withdraw amount: " + amount + " with balance: " + account.getBalance());
            }
            account.setBalance(account.getBalance() - amount);
            accountRepository.persist(account);
            createAccountTransaction(amount, operationType, account);
        } else {
            throw new RuntimeException("Account not found for account number: " + accountNumber);
        }
    }

    private void createAccountTransaction(int amount, String operationType, Account account) {
        AccountTransaction accountTransaction = new AccountTransaction();
        accountTransaction.setAccount(account);
        accountTransaction.setAmount(amount);
        accountTransaction.setTransactionType(operationType);
        accountTransactionRepository.persist(accountTransaction);
    }

    public List<AccountTransactionDto> printStatement(String accountNumber) {
        return accountTransactionRepository
                .findByAccountNumber(accountNumber)
                .map(accountTransaction -> {
                    AccountTransactionDto accountTransactionDto = new AccountTransactionDto(accountTransaction.getId(),
                            accountTransaction.getAccount().getAccountNumber(),
                            accountTransaction.getAmount(),
                            accountTransaction.getTransactionType());
                    return accountTransactionDto;
                }).toList();
    }
}
