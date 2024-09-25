package com.github.jesuserro.helloworldkmp

class InMemoryCountryRepository: CountryRepository {

    private var countries = listOf(
        Country("Spain", "ES", "🇪🇸"),
        Country("France", "FR", "🇫🇷"),
        Country("Italy", "IT", "🇮🇹"),
        Country("Germany", "DE", "🇩🇪"),
        Country("United Kingdom", "GB", "🇬🇧"),
        Country("United States", "US", "🇺🇸"),
        Country("Canada", "CA", "🇨🇦"),
        Country("Brazil", "BR", "🇧🇷"),
        Country("Argentina", "AR", "🇦🇷"),
        Country("Australia", "AU", "🇦🇺"),
        Country("China", "CN", "🇨🇳"),
        Country("Japan", "JP", "🇯🇵"),
        Country("South Korea", "KR", "🇰🇷"),
        Country("India", "IN", "🇮🇳"),
        Country("Russia", "RU", "🇷🇺")
    )

    override suspend fun getCountries(): List<Country> = countries
}