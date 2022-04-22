package com.example.pokedexapp.Service

import com.example.pokedexapp.dto.Pokemon
import com.example.pokedexapp.dto.Resource
import com.example.pokedexapp.dto.Results
import com.example.pokedexapp.network.RetrofitApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeDetailService {
    private val api = RetrofitApiFactory().getPokemonApi()

    fun getDetail(
        successCallback: (Resource) -> Unit,
        failureCallback: (errorMessage: String) -> Unit,
        tmpUrl: String,
    ) {

        api.getSpecificPokemon(tmpUrl).enqueue(object : Callback<Resource> {
            override fun onResponse(call: Call<Resource>, response: Response<Resource>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it)
                    } ?: run {
                        failureCallback("No pokemon returned from service")
                    }
                } else {
                    failureCallback("Error getting pokemon")
                }
            }

            override fun onFailure(call: Call<Resource>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }
}