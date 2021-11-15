package com.pokemon.neopokedexback.repository;

import com.pokemon.neopokedexback.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("pokemonRepository")
public interface PokemonRepository extends JpaRepository<Pokemon, Long>, CrudRepository<Pokemon, Long> {

    Boolean existsByNom(String nom);

    Boolean existsByNumero(long numero);
}
