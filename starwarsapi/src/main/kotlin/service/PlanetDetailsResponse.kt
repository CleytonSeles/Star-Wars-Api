package com.example.starwarsapi.service

import com.example.starwarsapi.model.Planetas

data class PlanetDetailsResponse(
    val planet: Planetas,
    val filmAppearances: Int // Número de filmes em que o planeta apareceu
)
