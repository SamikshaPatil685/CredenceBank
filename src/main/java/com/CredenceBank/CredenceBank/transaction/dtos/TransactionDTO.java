package com.CredenceBank.CredenceBank.transaction.dtos;


import com.CredenceBank.CredenceBank.account.dtos.AccountDTO;
import com.CredenceBank.CredenceBank.enums.TransactionStatus;
import com.CredenceBank.CredenceBank.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private Long id;

    private BigDecimal amount ;

    private TransactionType transactionType ;


    private LocalDateTime transactionDate;

    private TransactionStatus status ;

    @JsonManagedReference
    @JsonIgnore
    private AccountDTO account;

    //for transfer
    private  String sourceAccount ;
    private String destinationAccount;
}
