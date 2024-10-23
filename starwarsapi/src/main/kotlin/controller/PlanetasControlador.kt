package com.example.starwarsapi.controller

import com.example.starwarsapi.model.Planetas
import com.example.starwarsapi.service.PlanetService
import com.example.starwarsapi.service.PlanetDetailsResponse
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController // Indica que essa classe será um controlador REST
@RequestMapping("/planets") // Define a URL base para todos os endpoints deste controlador
class PlanetasControlador(val planetService: PlanetService) {

    // Endpoint para adicionar um novo planeta
    @PostMapping
    fun addPlanet(@RequestBody planet: Planetas): Planetas {
        return planetService.addPlanet(planet)
    }

    // Endpoint para listar todos os planetas
    @GetMapping
    fun listPlanets(): List<Planetas> {
        return planetService.listPlanets()
    }

    // Endpoint para buscar um planeta pelo ID
    @GetMapping("/{id}")

    fun getPlanetById(@PathVariable id: Long): Mono<PlanetDetailsResponse> {
        return planetService.getPlanetById(id)

    fun getPlanetById(@PathVariable id: Long): Planetas? {
        return planetService.getPlanetById(id)

    }

    // Endpoint para buscar planetas por nome
    @GetMapping("/search")
    fun getPlanetByName(@RequestParam name: String): List<Planetas> {
        return planetService.getPlanetByName(name)
    }

    // Endpoint para remover um planeta pelo ID
    @DeleteMapping("/{id}")
    fun removePlanet(@PathVariable id: Long) {
        planetService.removePlanet(id)
    }
}
