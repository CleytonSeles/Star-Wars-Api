package com.example.starwarsapi.service

import com.example.starwarsapi.client.SwapiClient
import com.example.starwarsapi.model.Planetas
import com.example.starwarsapi.repository.PlanetasRepositorio
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class PlanetService(
    val planetRepository: PlanetasRepositorio,
    val swapiClient: SwapiClient // Injetando o cliente SWAPI no serviço
    ) {

    // Método para adicionar um novo planeta
    fun addPlanet(planet: Planetas): Planetas {
        return planetRepository.save(planet)
    }

    // Método para listar todos os planetas
    fun listPlanets(): List<Planetas> {
        return planetRepository.findAll()
    }

    // Método para buscar um planeta pelo ID e também buscar a quantidade de filmes
    fun getPlanetById(id: Long): Mono<PlanetDetailsResponse> {
        val planet = planetRepository.findById(id).orElse(null) ?: return Mono.empty()

        // Chama o cliente SWAPI para obter os detalhes do planeta
        return swapiClient.getPlanetDetails(id).map { swapiResponse ->
            val filmAppearances = swapiResponse.films.size // Número de aparições nos filmes
            PlanetDetailsResponse(planet, filmAppearances)
        }
    }

    // Método para buscar planetas pelo nome
    fun getPlanetByName(name: String): List<Planetas> {
        return planetRepository.findByName(name)
    }

    // Método para remover um planeta pelo ID
    fun removePlanet(id: Long) {
        if (planetRepository.existsById(id)) {
            planetRepository.deleteById(id)
        } else {
            throw Exception("Planeta com ID $id não encontrado.")
        }
    }
}
