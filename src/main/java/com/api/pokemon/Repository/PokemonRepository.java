package com.api.pokemon.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.pokemon.Entity.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long>{
    
    

}
