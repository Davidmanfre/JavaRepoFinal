package com.coder.house.ventas.online.ventasonline.repository;

import com.coder.house.ventas.online.ventasonline.entidad.PokemonList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon")
    Call<PokemonList> getPokemonList(@Query("limit") int limit, @Query("offset") int offset);
}