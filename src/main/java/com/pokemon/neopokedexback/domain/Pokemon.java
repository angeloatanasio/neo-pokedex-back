package com.pokemon.neopokedexback.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "pokemon")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pokemon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "numero")
    private long numero;

    @Column(name = "nom", unique = true, nullable = false)
    private String nom;

    @OneToOne(targetEntity = Image.class, cascade = CascadeType.ALL)
    @Setter
    private Image image;

    @Column(name = "poids")
    private float poids;

    @Column(name = "taille")
    private float taille;

    @Column(name = "evolution")
    private String evolution;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Pokemon(long numero, String nom, Image image, float poids, float taille, String evolution, Type type) {
                this.numero = numero;
                this.nom = nom;
                this.image = image;
                this.poids = poids;
                this.taille = taille;
                this.evolution = evolution;
                this.type = type;
    }

    public Pokemon mettreAJour(Pokemon pokemon) {
       return new Pokemon(
                this.numero = pokemon.numero,
                this.nom = pokemon.nom,
                this.image = pokemon.image,
                this.poids = pokemon.taille,
                this.taille = pokemon.taille,
                this.evolution = pokemon.evolution,
                this.type = pokemon.type);

    }

    public void ajouterNomEvolutionPokemon(String nom) {
        this.evolution = nom;
    }

}
