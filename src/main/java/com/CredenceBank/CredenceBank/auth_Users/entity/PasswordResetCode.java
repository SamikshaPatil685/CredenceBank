package com.CredenceBank.CredenceBank.auth_Users.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //class database table represent करते
@Data   // Automatically generate करतं: getters , setters , toString() , equals(),hashCode()
@Builder    //Object creation elegant बनवतं.
@Table(name="password_reset_code")    //Database table name manually define करतो.
@AllArgsConstructor //All fields constructor generate करतो.
@NoArgsConstructor  //Empty constructor generate करतो.

public class PasswordResetCode {

    @Id     //Primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Database automatically id generate करेल.
    private Long id ;

    @Column(unique = true)
    private String code ;

    @OneToOne(targetEntity = User.class , fetch = FetchType.EAGER)
    @JoinColumn(nullable = false , name = "user_id")
    private User user ;

    private LocalDateTime expiryDate ;

    private boolean used;
}
