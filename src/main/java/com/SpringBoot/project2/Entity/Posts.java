package com.SpringBoot.project2.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;
    private String post;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;

}
