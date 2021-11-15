package com.pokemon.neopokedexback.dto;

import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class TypeDTO {
    private long id;
    private String nom;
    private Instant dateCreation;
}
