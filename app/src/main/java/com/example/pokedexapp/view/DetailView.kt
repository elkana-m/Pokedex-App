package com.example.pokedexapp.view

import com.example.pokedexapp.dto.Resource

interface DetailView {
    fun bindPokemonDetail(pokeResource: Resource)
    fun showError(errorMessage: String)

}