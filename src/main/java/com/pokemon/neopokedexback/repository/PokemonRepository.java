package com.pokemon.neopokedexback.repository;

import com.pokemon.neopokedexback.domain.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository("pokemonRepository")
public interface PokemonRepository extends JpaRepository<Pokemon, Long>, CrudRepository<Pokemon, Long> {

//    @Query("select p from Pokemon p where p.nom = :nom")
    Boolean existsByNom(String nom);

    Boolean existsByNumero(long numero);
}
