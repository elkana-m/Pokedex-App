package com.example.pokedexapp.view

import com.example.pokedexapp.Service.PokeService
import com.example.pokedexapp.dto.Pokemon
import com.example.pokedexapp.dto.Results
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class ListsPresenterTest {

    val view: ListsView = mockk(relaxed = true)
    val pokeservice: PokeService = mockk(relaxed= true)
    val presenter = ListsPresenter(view, pokeservice)

    @Test
//    fun getPokemon() {
    fun `On start, call get pokemon`() {
        presenter.start()

        verify { pokeservice.getPokemon(any(),any(), any()) }
    }

    @Test
//    fun getResponse()
    fun `When get pokemon, given response is success, then bind pokemon on view`(){
        // Arrange
        val aPokemon = buildPokemon()

        every { pokeservice.getPokemon(any(),any(), any()) } answers {
            firstArg<(List<Results?>) -> Unit>().invoke(aPokemon)
        }

        // Act
        presenter.start()

        // Assertion
        verify { view.bindPokemon(aPokemon) }
    }

    private fun buildPokemon(): List<Results?> {
        return listOf(
            Results(
                name = "charizard",
                url = "https://pokeapi.co/api/v2/pokemon/6/"
            )
        )
    }

}