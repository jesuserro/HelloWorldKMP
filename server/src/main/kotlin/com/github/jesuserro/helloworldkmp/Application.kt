package com.github.jesuserro.helloworldkmp

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {

    val repository = InMemoryCountryRepository()

    // Get the list of countries as a JSON response
    val countries = repository.getCountries().toString()

    routing {
        get("/") {

            // Respond with the list of countries in JSON format
            call.respondText(countries)
        }
    }
}