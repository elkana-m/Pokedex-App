package com.example.pokedexapp.view

import com.example.pokedexapp.Service.PokeService

class ListsPresenterFactory {
    companion object {
        fun createPresenter(view: ListsView): ListsPresenter {
            return ListsPresenter(
                view,
                PokeService()
            )
            // context.getSharedPreferences("key", Context.MODE_PRIVATE))
        }
    }
}