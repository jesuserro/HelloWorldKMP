package com.github.jesuserro.helloworldkmp.repository

import com.github.jesuserro.helloworldkmp.model.Country

interface CountryRepository {
    suspend fun getCountries(): List<Country>
}