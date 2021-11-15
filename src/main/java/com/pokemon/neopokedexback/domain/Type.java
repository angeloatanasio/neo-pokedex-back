package com.pokemon.neopokedexback.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "type")
@Getter
@NoArgsConstructor
public class Type implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nom", unique = true, nullable = false)
    private String nom;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<Pokemon> pokemons = new ArrayList<>();

    @CreatedDate
    @Column(name = "date_creation", updatable = false)
    @JsonIgnore
    private Instant dateCreation = Instant.now();

    public Type(String nom, Instant dateCreation) {
        this.nom = nom;
        this.dateCreation = dateCreation;
    }

}
