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
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ufId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "followingId",referencedColumnName = "id")
    private User users;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userId",referencedColumnName = "id")
    private User user;

}
