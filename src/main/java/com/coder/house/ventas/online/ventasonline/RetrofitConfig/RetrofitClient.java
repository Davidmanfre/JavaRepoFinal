package com.coder.house.ventas.online.ventasonline.RetrofitConfig;

import com.coder.house.ventas.online.ventasonline.repository.ComprobanteRepository;
import com.coder.house.ventas.online.ventasonline.repository.PokeApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "https://pokeapi.co/api/v2/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static PokeApiService getPokeApiService() {
        return getClient().create(PokeApiService.class);
    }
}