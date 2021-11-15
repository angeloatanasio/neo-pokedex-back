package com.pokemon.neopokedexback.repository;

import com.pokemon.neopokedexback.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ImageRepository extends JpaRepository<Image, Long> { }
