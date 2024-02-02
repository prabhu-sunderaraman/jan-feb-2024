package com.herbalife.resource;

import com.herbalife.dto.AccountOperationDto;
import com.herbalife.dto.AccountTransactionDto;
import com.herbalife.service.BankService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/bank")
@Tag(name = "Bank Resource", description = "Bank operations")
public class BankResource {
    @Inject
    BankService bankService;

    @Operation(summary = "Deposit amount to account")
    @APIResponse(responseCode = "200", description = "Deposit successful")
    @PUT
    @Path("/deposit")
    public void deposit(AccountOperationDto accountOperationDto) {
        bankService.deposit(accountOperationDto.accountNumber(), accountOperationDto.amount(), accountOperationDto.operationType());
    }

    @Operation(summary = "Withdraw amount from account")
    @APIResponse(responseCode = "200", description = "Withdraw successful")
    @PUT
    @Path("/withdraw")
    public void withdraw(AccountOperationDto accountOperationDto) {
        bankService.withdraw(accountOperationDto.accountNumber(), accountOperationDto.amount(), accountOperationDto.operationType());
    }

    @GET
    @Path("/statement/{accountNumber}")
    public List<AccountTransactionDto> printStatement(@PathParam("accountNumber") String accountNumber) {
        return bankService.printStatement(accountNumber);
    }


//    deposit  (pass the account number, amount and type(Salary, Dividend, etc.,)
//    withdraw (pass the account number, amount and type(Interest, Card charges etc.,)); check for available balance
//    printStatement for an account number (return a list of transactions)
}
