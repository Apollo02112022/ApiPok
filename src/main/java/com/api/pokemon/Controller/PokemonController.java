package com.api.pokemon.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.api.pokemon.Entity.Pokemon;
import com.api.pokemon.Repository.PokemonRepository;

@RestController

public class PokemonController {

    @Autowired
    private PokemonRepository pokemonRepository;  

    // Create

    @PostMapping("/pokemons")
    public Pokemon create(@RequestBody Pokemon pokemon){
    return pokemonRepository.save(pokemon);
    }

    // Read 

    @GetMapping("/pokemons")
    public List<Pokemon> findAllPokemons() {
    return pokemonRepository.findAll();
    }

    @GetMapping("/pokemons/{id}/profil")
    public Pokemon findPokemon(@PathVariable Long id) {
    return pokemonRepository.findById(id).get();
    }

    // Update

    @PutMapping("/pokemons/{id}/profil")
    public Pokemon UpdatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemon) {

    Pokemon pokemonToUpdate = pokemonRepository.findById(id).get();
    pokemonToUpdate.setName(pokemon.getName());
    pokemonToUpdate.setType(pokemon.getType());
    return pokemonRepository.save(pokemonToUpdate);
    }

    // Delete

    @DeleteMapping("/pokemons/{id}/profil") 
    public boolean deletePokemon(@PathVariable Long id) {
    pokemonRepository.deleteById(id);
    return true;
    }

}
