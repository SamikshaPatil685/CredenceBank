package com.CredenceBank.CredenceBank.transaction.services;

import com.CredenceBank.CredenceBank.res.Response;
import com.CredenceBank.CredenceBank.transaction.dtos.TransactionDTO;
import com.CredenceBank.CredenceBank.transaction.dtos.TransactionRequest;

import java.util.List;

public interface TransactionService {
    Response<?> createTransaction(TransactionRequest transactionRequest);
    Response<List<TransactionDTO>> getTransactionsForMyAccount(String accountNumber, int page, int size);

}
