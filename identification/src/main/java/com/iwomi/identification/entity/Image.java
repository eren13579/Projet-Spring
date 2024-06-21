package com.iwomi.identification.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "IMAGE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CODE_IMAGE")
    private long id;
    @Column(name ="NAME_IMAGE", length = 520)
    private String name;
    @Column(name ="Taille_IMAGE", length = 520)
    private int size;
    @Column(name = "FILE_IMAGE")
    private byte fileImage;

}
