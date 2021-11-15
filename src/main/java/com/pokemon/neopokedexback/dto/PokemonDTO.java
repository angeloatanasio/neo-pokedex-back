package com.pokemon.neopokedexback.dto;

import lombok.Data;

@Data
public class PokemonDTO {

    private long id;
    private long numero;
    private String nom;
    private ImageDTO image;
    private float poids;
    private float taille;
    private String evolution;
    private TypeDTO type;


}
