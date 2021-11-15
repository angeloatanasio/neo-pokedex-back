package com.pokemon.neopokedexback.mapper;

import com.pokemon.neopokedexback.domain.Type;
import com.pokemon.neopokedexback.dto.TypeDTO;
import com.pokemon.neopokedexback.shared.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeMapper extends EntityMapper<TypeDTO, Type> {

    TypeMapper typeMapper = Mappers.getMapper(TypeMapper.class);

    @Override
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nom", target = "nom"),
            @Mapping(source = "dateCreation",  target = "dateCreation")
    })
    TypeDTO toDto(Type entity);


    @Override
    List<TypeDTO> toDto(List<Type> entityList);
}
