package com.example.pokedexapp.network

import com.example.pokedexapp.dto.Pokemon
import com.example.pokedexapp.dto.Resource
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeApi {

    @GET("pokemon?&limit=20")
    fun get20Pokemon(@Query("offset") index: Int): Call<Pokemon>

    @GET("{url}")
    fun getSpecificPokemon(@Path("url") url: String): Call<Resource>
}

