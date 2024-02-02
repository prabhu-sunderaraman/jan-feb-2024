package com.herbalife.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "account_number")
    private String accountNumber;

    @Column
    private String owner;

    @Column
    private int balance;
}
