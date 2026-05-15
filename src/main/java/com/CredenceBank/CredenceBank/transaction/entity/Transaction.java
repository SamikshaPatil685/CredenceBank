package com.CredenceBank.CredenceBank.transaction.entity;


import com.CredenceBank.CredenceBank.account.entity.Account;
import com.CredenceBank.CredenceBank.enums.TransactionStatus;
import com.CredenceBank.CredenceBank.enums.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity //class database table represent करते
@Data   // Automatically generate करतं: getters , setters , toString() , equals(),hashCode()
@Builder    //Object creation elegant बनवतं.
@Table(name="transaction")    //Database table name manually define करतो.
@AllArgsConstructor //All fields constructor generate करतो.
@NoArgsConstructor  //Empty constructor generate करतो.

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount ;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private TransactionType transactionType ;

    @Column(nullable = false)
    private LocalDateTime transactionDate = LocalDateTime.now();

    private String description;

    @Enumerated (EnumType.STRING)
    private TransactionStatus status ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Account_id" , nullable = false)
    private Account account;

    //for transfer
    private  String sourceAccount ;
    private String destinationAccount;
}
