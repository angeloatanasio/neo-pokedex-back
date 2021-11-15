package com.pokemon.neopokedexback.command;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NouveauTypeCommand {

    private String nom;

    @JsonCreator
    public NouveauTypeCommand(@JsonProperty("nom") String nom) {
        this.nom = nom;
    }
}
