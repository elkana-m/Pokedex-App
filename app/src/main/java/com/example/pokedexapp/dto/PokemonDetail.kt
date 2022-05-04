package com.example.pokedexapp.dto

data class Resource(
    val abilities: List<Abilities?>,
    val forms: List<Forms?>,
    val sprites: Sprites?,
    val stats: List<Stats?>
    )

// Where the abilities are saved
data class Abilities(
    val ability: Ability?
)
data class Ability(
    val name: String?
)

// Where the name is saved
data class Forms(
    val name: String?
    )

// Where the front_default is saved
data class Sprites(
    val front_default: String?,
    val front_shiny: String?
)

// Where the base stats are saved
data class Stats(
    val base_stat: Int?
)