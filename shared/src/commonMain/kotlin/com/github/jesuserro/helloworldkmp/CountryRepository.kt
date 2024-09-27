package com.github.jesuserro.helloworldkmp

interface CountryRepository {
    suspend fun getCountries(): List<Country>
}