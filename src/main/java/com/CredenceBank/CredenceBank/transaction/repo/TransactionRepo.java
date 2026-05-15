package com.CredenceBank.CredenceBank.transaction.repo;

import com.CredenceBank.CredenceBank.account.entity.Account;
import com.CredenceBank.CredenceBank.transaction.entity.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction , Long> {
    Page<Transaction>findByAccount_AccountNumber(String accountNumber , Pageable pageable);

    List<Transaction>findByAccount_AccountNumber(String accountNumber);

    List<Transaction>findByAccount_AccountNumber(Account account);
}
