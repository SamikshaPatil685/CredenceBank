package com.CredenceBank.CredenceBank.account.services;

import com.CredenceBank.CredenceBank.account.dtos.AccountDTO;
import com.CredenceBank.CredenceBank.account.entity.Account;
import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import com.CredenceBank.CredenceBank.enums.AccountType;
import com.CredenceBank.CredenceBank.res.Response;

import java.util.List;

public interface AccountService {

    Account createAccount(AccountType accountType, User user);

    Response<List<AccountDTO>> getMyAccounts();

    Response<?> closeAccount(String accountNumber);
}
