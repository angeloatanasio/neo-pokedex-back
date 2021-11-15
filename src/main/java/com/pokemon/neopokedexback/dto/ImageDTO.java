package com.pokemon.neopokedexback.dto;

import lombok.Data;

@Data
public class ImageDTO {
    private String nom;
    private String type;
    private byte[] picByte;
}
