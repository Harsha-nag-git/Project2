package com.SpringBoot.project2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
