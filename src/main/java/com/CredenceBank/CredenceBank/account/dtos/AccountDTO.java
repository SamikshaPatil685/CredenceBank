package com.CredenceBank.CredenceBank.account.dtos;


import com.CredenceBank.CredenceBank.auth_Users.dtos.UserDTO;
import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import com.CredenceBank.CredenceBank.enums.AccountStatus;
import com.CredenceBank.CredenceBank.enums.AccountType;
import com.CredenceBank.CredenceBank.enums.Currency;
import com.CredenceBank.CredenceBank.transaction.dtos.TransactionDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data   // Automatically generate करतं: getters , setters , toString() , equals(),hashCode()
@Builder    //Object creation elegant बनवतं.
@AllArgsConstructor //All fields constructor generate करतो.
@NoArgsConstructor  //Empty constructor generate करतो.
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    private Long id;

    private String accountNumber;

    private BigDecimal balance;

    private AccountType accountType;

    @JsonBackReference// this will not be added to the account dto. It will be ignored because it is a back refrence
    private UserDTO user;

    private Currency currency;

    private AccountStatus status;

    @JsonManagedReference// if helps avoid recursion loop by ignoring the AccountDTO withing the TransactionDTO
    private List<TransactionDTO> transactions;

    private LocalDateTime closedAt;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
