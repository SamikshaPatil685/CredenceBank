package com.CredenceBank.CredenceBank.auth_Users.entity;


import com.CredenceBank.CredenceBank.account.entity.Account;
import com.CredenceBank.CredenceBank.role.entity.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity //class database table represent करते
@Data   // Automatically generate करतं: getters , setters , toString() , equals(),hashCode()
@Builder    //Object creation elegant बनवतं.
@Table(name="users")    //Database table name manually define करतो.
@AllArgsConstructor //All fields constructor generate करतो.
@NoArgsConstructor  //Empty constructor generate करतो.

public class User {

    @Id     //Primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Database automatically id generate करेल.
    private Long id ;

    private String firstName ;
    private String lastName ;
    private String phoneNumber ;

    @Email
    @Column(unique = true , nullable = false)
    @NotBlank
    private String email;
    private String password ;
    private String profilePictureUrl; ;
    private boolean active=true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "Users_roles",
            joinColumns = @JoinColumn(name = "User_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles ;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
    private List<Account> accounts ;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;


}
