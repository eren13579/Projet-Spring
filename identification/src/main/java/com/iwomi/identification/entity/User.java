package com.iwomi.identification.entity;

import com.iwomi.identification.liste.EnumRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nom", length = 520, unique = true, nullable = false)
    private String username;
    @Column(name = "mot_de_passe", length = 520, nullable = false)
    private String password;
    private String role;
    @Column(name = "ROLE_USERS")
    private EnumRole roleUser;
    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "CODE_IDEN", referencedColumnName = "NUMERO_DE_CODE")
    private Identifier identifier;
}
