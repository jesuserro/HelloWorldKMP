package com.github.jesuserro.helloworldkmp

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.request
import io.ktor.serialization.kotlinx.json.json

interface CountryRepository {

    private val COUNTRIES_URL: String
        get() = "http://localhost:$SERVER_PORT"

    private val client: HttpClient
        get() = HttpClient {
            install(ContentNegotiation){
                json()
            }
        }

    suspend fun getCountries(): List<Country> = client.request(COUNTRIES_URL).body()
}