package com.example.starwarsapi.client

data class SwapiPlanetResponse(
    val name: String,
    val climate: String,
    val terrain: String,
    val films: List<String> // Armazena os URLs dos filmes
)
