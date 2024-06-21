package com.iwomitech.identifierUsers.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USERS")
    private long id;
    @Column(name = "USERNAME", length = 520, unique = true, nullable = false)
    private String username;
    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;
    @Column(name = "ROLE")
    private ListUsers role;

}
