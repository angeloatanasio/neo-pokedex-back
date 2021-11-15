package com.pokemon.neopokedexback.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokemon.neopokedexback.dto.NouveauPokemonDTO;
import com.pokemon.neopokedexback.dto.PokemonDTO;
import com.pokemon.neopokedexback.facade.PokemonFacade;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/pokemon")
@Slf4j
@RequiredArgsConstructor
public class PokemonController {

    private final PokemonFacade pokemonFacade;

    @GetMapping("/findAll")
    @CrossOrigin
    public ResponseEntity<List<PokemonDTO>> findAll() {
        log.debug("pokemon controller -> liste pokemon  : ",pokemonFacade.findAll());
        return ResponseEntity.ok(pokemonFacade.findAll());
    }

    @PostMapping(value = "/save")
    @CrossOrigin
    public ResponseEntity<PokemonDTO> save(
            @RequestPart(value = "file", required = false) final MultipartFile file,
            @ModelAttribute("pokemonModel") final String model) throws IOException {
        log.debug("pokemon controller -> sauvegarde d'un nouveau pokemon ");
       return ResponseEntity.ok(pokemonFacade.enregistrerNouveauPokemon(new ObjectMapper().readValue(model, NouveauPokemonDTO.class), file));
    }

    @GetMapping(value = "existe/{data}")
    @CrossOrigin
    public ResponseEntity<Boolean> existeParNumeroOuNom(@PathVariable String data) {
        log.debug("pokemon controller -> vérification si le numéro ou le nom renseigné existe déjà ");
        return ResponseEntity.ok(pokemonFacade.existeParNumeroOuNom(data));
    }
}
