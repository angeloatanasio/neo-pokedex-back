package com.pokemon.neopokedexback.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "image")
@Getter
@NoArgsConstructor
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "type")
    private String type;

    @Column(name = "pic_byte", length = 100000)
    private byte[] picByte;

    @OneToOne(targetEntity = Pokemon.class)
    private Pokemon pokemon;

    public Image(String nom, String type, byte[] picByte) {
        this.nom = nom;
        this.type = type;
        this.picByte = picByte;
    }

}
