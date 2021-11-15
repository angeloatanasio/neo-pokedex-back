package com.pokemon.neopokedexback.dto;

import lombok.Data;

@Data
public class NouveauPokemonDTO {
    private long numero;
    private String nom;
    private float poids;
    private float taille;
    private String evolution;
    private long typeId;

}
