package com.herbalife.lab04;

import java.time.LocalDateTime;

public record TransactionRecord(long accountNumber,
                                double amount,
                                TransactionType type,
                                LocalDateTime localDateTime) {
}
