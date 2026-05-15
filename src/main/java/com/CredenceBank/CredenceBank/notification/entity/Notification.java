package com.CredenceBank.CredenceBank.notification.entity;

import com.CredenceBank.CredenceBank.auth_Users.entity.User;
import com.CredenceBank.CredenceBank.enums.NotificationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity //class database table represent करते
@Data   // Automatically generate करतं: getters , setters , toString() , equals(),hashCode()
@Builder    //Object creation elegant बनवतं.
@Table(name="notifications")    //Database table name manually define करतो.
@AllArgsConstructor //All fields constructor generate करतो.
@NoArgsConstructor  //Empty constructor generate करतो.

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String subject;
    private String recipient;

    private  String body ;

    @Enumerated(EnumType.STRING)
    private NotificationType type; //EMAIL , SMS

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private final LocalDateTime createdAt = LocalDateTime.now();

}
