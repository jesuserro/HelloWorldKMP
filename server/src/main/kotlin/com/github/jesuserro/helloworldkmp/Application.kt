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
    routing {
        get("/") {
            // call.respondText("Ktor: ${Greeting().greet()}")

            // Show a list of countries in JSON prettify format
            call.respondText(
                text = countries.joinToString(prefix = "[\n", postfix = "\n]", separator = ",\n") {
                    "  { \"name\": \"${it.name}\", \"code\": \"${it.code}\", \"emoji\": \"${it.emoji}\" }"
                }
            )
        }
    }
}