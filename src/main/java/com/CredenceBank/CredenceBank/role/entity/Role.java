package com.CredenceBank.CredenceBank.role.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //class database table represent करते
@Data   // Automatically generate करतं: getters , setters , toString() , equals(),hashCode()
@Builder    //Object creation elegant बनवतं.
@Table(name="roles")    //Database table name manually define करतो.
@AllArgsConstructor //All fields constructor generate करतो.
@NoArgsConstructor  //Empty constructor generate करतो.
public class Role {

    @Id //Primary key define करतो.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Database automatically id generate करेल.
    private Long id ;

 //   private Boolean active = true ;

    @Column(unique = true)  //Duplicate role names allow नाही.
    @NotBlank(message = "Role name is required !!")     //Empty values prevent करतो.
    private String name;  //ROLE NAME e.g. CUSTOMER , AUDITOR , ADMIN

}
