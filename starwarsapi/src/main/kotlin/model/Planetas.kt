package com.example.starwarsapi.model

import javax.persistence.*

@Entity // Esta anotação define que essa classe será uma entidade JPA
data class Planetas(
    @Id // Define que esse campo será a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O valor será gerado automaticamente
    val id: Long = 0, // O tipo Long é usado para IDs únicos

    @Column(nullable = false) // Define que o campo não pode ser nulo
    val name: String, // Nome do planeta

    @Column(nullable = false) // Define que o campo não pode ser nulo
    val climate: String, // Clima do planeta

    @Column(nullable = false) // Define que o campo não pode ser nulo
    val terrain: String, // Terreno do planeta

    val movieAppearances: Int = 0 // Número de aparições em filmes, com valor padrão 0
)
