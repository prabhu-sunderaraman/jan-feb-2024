package com.herbalife.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "account-transactions")
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private int id;

    @Column
    private int amount;

    @Column(name = "transaction_type")
    private String transactionType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_number")
    private Account account;

}
