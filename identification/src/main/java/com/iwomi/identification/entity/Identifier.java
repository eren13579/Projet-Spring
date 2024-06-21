package com.iwomi.identification.entity;

import com.iwomi.identification.liste.EnumType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IDENTIFIANT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identifier {
    
    @Id
    @Column(name = "NUMERO_DE_CODE")
    private String numeroCode;
    @Column(name = "NOM", length = 520)
    private String firstName;
    @Column(name = "PRENOM", length = 520)
    private String lastName;
    @Column(name = "TYPE", length = 520, nullable = false)
    private EnumType type;
    @ManyToOne(optional = false)
    @JoinColumn(name = "ID_IMAGE", referencedColumnName = "CODE_IMAGE")
    private Image image;
}
