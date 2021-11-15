package com.pokemon.neopokedexback.facade;

import com.pokemon.neopokedexback.command.NouveauTypeCommand;
import com.pokemon.neopokedexback.domain.Type;
import com.pokemon.neopokedexback.dto.TypeDTO;
import com.pokemon.neopokedexback.mapper.TypeMapper;
import com.pokemon.neopokedexback.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class TypeFacade {

    private final TypeRepository typeRepository;
    private final TypeMapper typeMapper;

    public List<TypeDTO> findAll() {
        List<Type> listeTypes = typeRepository.findAll()
                .stream().sorted(Comparator.comparing(Type::getNom)).collect(Collectors.toList());
        return typeMapper.toDto(listeTypes);
    }

    public TypeDTO enregistrerNouveautype(NouveauTypeCommand nouveauTypeCommand) {
        Type nouveauTypeEnregistre = typeRepository.save(new Type(nouveauTypeCommand.getNom(), Instant.now()));
        return typeMapper.toDto(nouveauTypeEnregistre);
    }

    public Boolean existeParNom(String nom) {
        return typeRepository.existsByNom(nom.trim().toLowerCase());
    }
}
