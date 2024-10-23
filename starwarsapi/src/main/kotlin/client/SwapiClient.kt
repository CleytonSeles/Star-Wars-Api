package com.example.starwarsapi.client

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class SwapiClient {

    private val webClient: WebClient = WebClient.create("https://swapi.dev/api/planets")

    // Método para buscar os detalhes de um planeta por ID na API SWAPI
    fun getPlanetDetails(id: Long): Mono<SwapiPlanetResponse> {
        return webClient.get()
            .uri("/$id/")
            .retrieve()
            .bodyToMono(SwapiPlanetResponse::class.java)
    }
}
