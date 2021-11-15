package com.pokemon.neopokedexback.repository;

import com.pokemon.neopokedexback.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("typeRepository")
public interface TypeRepository extends JpaRepository<Type, Long>, CrudRepository<Type,Long > {
    Boolean existsByNom(String nom);
}
