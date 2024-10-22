package com.example.starwarsapi.service

import com.example.starwarsapi.model.Planetas
import com.example.starwarsapi.repository.PlanetasRepositorio
import org.springframework.stereotype.Service

@Service
class PlanetService(val planetRepository: PlanetasRepositorio) {

    // Método para adicionar um novo planeta
    fun addPlanet(planet: Planetas): Planetas {
        return planetRepository.save(planet)
    }

    // Método para listar todos os planetas
    fun listPlanets(): List<Planetas> {
        return planetRepository.findAll()
    }

    // Método para buscar um planeta pelo ID
    fun getPlanetById(id: Long): Planetas? {
        return planetRepository.findById(id).orElse(null)
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
