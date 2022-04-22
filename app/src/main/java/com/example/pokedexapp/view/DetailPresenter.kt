package com.example.pokedexapp.view

import com.example.pokedexapp.Service.PokeDetailService

class DetailPresenter (
    private val view: DetailView,
    private val pokeDetailService: PokeDetailService,
    private val tmpUrl: String
){
    fun start() {
        getDetail()
    }


    private fun getDetail() {
        pokeDetailService.getDetail(
            successCallback = { resource ->
                view.bindPokemonDetail(resource)
            },

            failureCallback = { errorMessage ->
                view.showError(errorMessage)
            },

            tmpUrl
        )

    }

}
