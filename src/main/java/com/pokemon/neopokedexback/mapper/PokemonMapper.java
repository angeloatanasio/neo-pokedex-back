package com.pokemon.neopokedexback.mapper;


import com.pokemon.neopokedexback.domain.Pokemon;
import com.pokemon.neopokedexback.dto.PokemonDTO;
import com.pokemon.neopokedexback.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PokemonMapper extends EntityMapper<PokemonDTO, Pokemon> {

    PokemonMapper pokemonMapper = Mappers.getMapper(PokemonMapper.class);

    @Override
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "numero", target = "numero"),
            @Mapping(source = "nom", target = "nom"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "poids", target = "poids"),
            @Mapping(source = "taille", target = "taille"),
            @Mapping(source = "evolution", target = "evolution"),
            @Mapping(source = "type", target = "type")
    })
    PokemonDTO toDto(Pokemon entity);

    @Override
    List<PokemonDTO> toDto(List<Pokemon> entityList);
}
