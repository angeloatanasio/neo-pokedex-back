package com.pokemon.neopokedexback.facade;

import com.pokemon.neopokedexback.domain.Image;
import com.pokemon.neopokedexback.domain.Pokemon;
import com.pokemon.neopokedexback.dto.NouveauPokemonDTO;
import com.pokemon.neopokedexback.dto.PokemonDTO;
import com.pokemon.neopokedexback.mapper.PokemonMapper;
import com.pokemon.neopokedexback.repository.ImageRepository;
import com.pokemon.neopokedexback.repository.PokemonRepository;
import com.pokemon.neopokedexback.repository.TypeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PokemonFacade {

    private final PokemonRepository pokemonRepository;
    private final TypeRepository typeRepository;
    private final PokemonMapper pokemonMapper;
    private final ImageRepository imageRepository;

    public List<PokemonDTO> findAll() {

        List<Pokemon> pokemons = pokemonRepository.findAll()
                .stream()
                .sorted(Comparator.comparingLong(Pokemon::getNumero))
                .collect(Collectors.toList());

        return pokemonMapper.toDto(pokemons);
    }

    public PokemonDTO enregistrerNouveauPokemon(NouveauPokemonDTO nouveauPokemonDTO, MultipartFile file) throws IOException {
        Image imageSauvegarde = null;
        if (file != null) {
            Image img = new Image(file.getOriginalFilename(), file.getContentType(), file.getBytes());
            imageSauvegarde = imageRepository.save(img);
        }
        Pokemon nouveauPokemon = new Pokemon(
                nouveauPokemonDTO.getNumero(),
                nouveauPokemonDTO.getNom(),
                imageSauvegarde,
                nouveauPokemonDTO.getPoids(),
                nouveauPokemonDTO.getTaille(),
                nouveauPokemonDTO.getEvolution(),
                typeRepository.findById(nouveauPokemonDTO.getTypeId()).orElseThrow(() -> new IllegalArgumentException("TYPE NOT FOUND")));

        if (!nouveauPokemonDTO.getEvolution().equals("")
                && NumberUtils.isCreatable(nouveauPokemonDTO.getEvolution())
                && pokemonRepository.findById(Long.parseLong(nouveauPokemonDTO.getEvolution())).isPresent()) {
            nouveauPokemon.ajouterNomEvolutionPokemon(pokemonRepository.findById(Long.parseLong(nouveauPokemonDTO.getEvolution())).get().getNom());
        }
        return pokemonMapper.toDto(pokemonRepository.save(nouveauPokemon));
    }

    public Boolean existeParNumeroOuNom(String numeroOuNom) {
        return NumberUtils.isCreatable(numeroOuNom.trim()) ? pokemonRepository.existsByNumero(Long.parseLong(numeroOuNom))
                : pokemonRepository.existsByNom(numeroOuNom.trim().toLowerCase(Locale.ROOT));
    }
}
