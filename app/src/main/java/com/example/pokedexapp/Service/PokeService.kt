package com.example.pokedexapp.Service

import android.widget.EditText
import com.example.pokedexapp.dto.Pokemon
import com.example.pokedexapp.dto.Results
import com.example.pokedexapp.network.RetrofitApiFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokeService {
    private val api = RetrofitApiFactory().getPokemonApi()

    fun getPokemon(
        successCallback: (List<Results?>) -> Unit,
        failureCallback: (errorMessage: String) -> Unit,
        pageIndex: Int,
    ) {
        val index = (pageIndex-1) * 20
        api.get20Pokemon(index).enqueue(object : Callback<Pokemon> {
            override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        successCallback(it.results)
                    } ?: run {
                        failureCallback("No pokemon returned from service")
                    }
                } else {
                    failureCallback("Error getting pokemon")
                }
            }

            override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                failureCallback("Error: ${t.message}")
            }
        })

    }
}