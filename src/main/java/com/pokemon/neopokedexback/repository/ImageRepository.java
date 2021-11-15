package com.pokemon.neopokedexback.repository;

import com.pokemon.neopokedexback.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByNom(String nom);
}