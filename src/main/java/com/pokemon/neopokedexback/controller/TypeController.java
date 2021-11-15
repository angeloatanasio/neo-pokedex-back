package com.pokemon.neopokedexback.controller;

import com.pokemon.neopokedexback.command.NouveauTypeCommand;
import com.pokemon.neopokedexback.dto.TypeDTO;
import com.pokemon.neopokedexback.facade.TypeFacade;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/type")
@RequiredArgsConstructor
@Slf4j
public class TypeController {

    private final TypeFacade typeFacade;

    @GetMapping(value ="/findAll")
    @CrossOrigin
    public ResponseEntity<List<TypeDTO>> findAll() {
        log.debug("type controller -> récupérer tous les types  ");
        return ResponseEntity.ok(typeFacade.findAll());
    }

    @PostMapping(value = "/save")
    @CrossOrigin
    public ResponseEntity<TypeDTO> enregistrerNouveauType(@RequestBody NouveauTypeCommand nouveauTypeCommand) {
        log.debug("type controller -> sauvegarde d'un nouveau type ");
        return ResponseEntity.ok(typeFacade.enregistrerNouveautype(nouveauTypeCommand));
    }

    @GetMapping(value = "/existe/{data}")
    @CrossOrigin
    public ResponseEntity<Boolean> existeParNom(@PathVariable String data) {
        log.debug("type controller -> vérifier si un nouveau type existe déjà ");
        return ResponseEntity.ok(typeFacade.existeParNom(data));
    }
}
