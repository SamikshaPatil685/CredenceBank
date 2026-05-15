package com.CredenceBank.CredenceBank.audit_dashboard.service;

import com.CredenceBank.CredenceBank.account.dtos.AccountDTO;
import com.CredenceBank.CredenceBank.auth_Users.dtos.UserDTO;
import com.CredenceBank.CredenceBank.transaction.dtos.TransactionDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AuditorService {

    Map<String, Long> getSystemTotals();

    Optional<UserDTO> findUserByEmail(String email);

    Optional<AccountDTO> findAccountDetailsByAccountNumber(String accountNumber);

    List<TransactionDTO> findTransactionsByAccountNumber(String accountNumber);

    Optional<TransactionDTO> findTransactionById(Long transactionId);
}
