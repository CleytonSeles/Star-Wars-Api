package com.example.starwarsapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StarwarsapiApplication

fun main(args: Array<String>) {
	runApplication<StarwarsapiApplication>(*args)
}
