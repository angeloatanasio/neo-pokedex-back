package com.pokemon.neopokedexback.shared.idObject;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class TypeId implements Serializable {

    private Long id;


    public TypeId(Long id) {
        Objects.requireNonNull(id,"Id ne peut être null");
        this.id = id;
    }

    protected  TypeId(){}
}
