package com.example.pokedexapp.view

import android.widget.Button
import com.example.pokedexapp.dto.Results

interface ListsView {
    fun queryBtn(): Button

    fun findPageIndex():Int
    fun bindPokemon(pokeList: List<Results?>)
    fun showError(errorMessage: String)
    //fun bindCategories(categories: List<String>)
}