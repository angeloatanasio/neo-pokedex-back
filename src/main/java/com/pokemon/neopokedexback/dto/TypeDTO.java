package com.pokemon.neopokedexback.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class TypeDTO {
    private long id;
    private String nom;
    private Instant dateCreation;
}
