package com.SpringBoot.project2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_log")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(
            nullable = false,
            unique = true
    )
    private String firstName;
    private String lastName;
    @Column(
            unique = true,
            nullable = false
    )
    @Email
    private String email;
    @Column(
            nullable = false
    )
    private String password;

}
