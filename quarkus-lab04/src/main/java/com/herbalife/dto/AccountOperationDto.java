package com.herbalife.dto;


import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "AccountOperationDto", description = "Account operation details")
public record AccountOperationDto(@Schema(required = true, example = "987897987") String accountNumber,
                                  @Schema(required = true) int amount,
                                  @Schema(required = true, example = "CREDIT | DEBIT") String operationType) {
}
