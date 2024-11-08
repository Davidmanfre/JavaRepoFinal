package com.coder.house.ventas.online.ventasonline.service;

import com.coder.house.ventas.online.ventasonline.RetrofitConfig.RetrofitClient;
import com.coder.house.ventas.online.ventasonline.entidad.Pokemon;
import com.coder.house.ventas.online.ventasonline.entidad.PokemonList;
import com.coder.house.ventas.online.ventasonline.repository.PokeApiService;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PokemonService {

    private final PokeApiService pokeApiService;

    public PokemonService() {
        this.pokeApiService = RetrofitClient.getPokeApiService();
    }

    public CompletableFuture<List<Pokemon>> fetchPokemonList(int limit, int offset) {
        CompletableFuture<List<Pokemon>> future = new CompletableFuture<>();

        Call<PokemonList> call = pokeApiService.getPokemonList(limit, offset);
        call.enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful() && response.body() != null) {
                    future.complete(response.body().getResults());
                } else {
                    future.completeExceptionally(new RuntimeException("Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                future.completeExceptionally(t);
            }
        });

        return future;
    }
}