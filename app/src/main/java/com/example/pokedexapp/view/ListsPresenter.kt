package com.example.pokedexapp.view

import com.example.pokedexapp.Service.PokeService

class ListsPresenter (
    private val view: ListsView,
    private val pokeservice: PokeService
)   {

    fun start() {
        getPokemon()
    }


    private fun getPokemon() {
        pokeservice.getPokemon(
            successCallback = { poke ->
                view.bindPokemon(poke)
                // recyclerview is created and bind within bindPokemon(List<Results?>)
                queryBtnPressed()
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            },
            view.findPageIndex()
        )
    }

    private fun queryBtnPressed() {
        view.queryBtn().setOnClickListener()
        {
            getPokemon()
        }
    }


}