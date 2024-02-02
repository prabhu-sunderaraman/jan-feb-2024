package com.herbalife.dto;

public record AccountTransactionDto(int id, String accountNumber, int amount, String operationType) {
}
