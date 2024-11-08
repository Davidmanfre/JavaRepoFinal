package com.coder.house.ventas.online.ventasonline.controller;

import com.coder.house.ventas.online.ventasonline.entidad.Pokemon;
import com.coder.house.ventas.online.ventasonline.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemons")
    public CompletableFuture<ResponseEntity<List<Pokemon>>> getPokemons(@RequestParam(defaultValue = "150") int limit,
                                                                        @RequestParam(defaultValue = "0") int offset) {
        return pokemonService.fetchPokemonList(limit, offset)
                .thenApply(ResponseEntity::ok)
                .exceptionally(ex -> ResponseEntity.status(500).body(null));
    }
}