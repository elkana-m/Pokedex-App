package com.example.pokedexapp.view

import com.example.pokedexapp.Service.PokeDetailService

class DetailPresenterFactory{
    companion object {
        fun createPresenter(view: DetailView, tmpURL: String): DetailPresenter{
            return DetailPresenter(
                view,
                PokeDetailService(),
                tmpURL
            )
        }
    }
}