package com.pokemon.neopokedexback.shared.idObject;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PokemonId implements Serializable {

    private Long id;

    public PokemonId (Long id) {
        Objects.requireNonNull(id, "id ne peut -être null");
        this.id = id;
    }

    protected PokemonId() {}
}
