package com.example.starwarsapi.repository

import com.example.starwarsapi.model.Planetas
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlanetasRepositorio : JpaRepository<Planetas, Long> {
    // Método customizado para buscar planetas pelo nome
    fun findByName(name: String): List<Planetas>
}
