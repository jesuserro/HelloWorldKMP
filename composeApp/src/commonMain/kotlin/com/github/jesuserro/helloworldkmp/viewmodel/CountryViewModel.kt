package com.github.jesuserro.helloworldkmp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jesuserro.helloworldkmp.Greeting
import com.github.jesuserro.helloworldkmp.model.Country
import com.github.jesuserro.helloworldkmp.repository.CountryRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class CountryViewModel(private val repository: CountryRepository) : ViewModel() {
    private val _countries = MutableStateFlow<List<Country>>(emptyList())
    val countries: StateFlow<List<Country>> = _countries.asStateFlow()

    private val _greeting = MutableStateFlow(Greeting().greet())
    val greeting: StateFlow<String> = _greeting.asStateFlow()

    private val _showContent = MutableStateFlow(false)
    val showContent: StateFlow<Boolean> = _showContent.asStateFlow()

    init {
        viewModelScope.launch { _countries.value = repository.getCountries() }
    }

    fun toggleShowContent() {
        _showContent.value = !_showContent.value
    }
}