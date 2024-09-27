package com.github.jesuserro.helloworldkmp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.github.jesuserro.helloworldkmp.repository.CountryRepository
import kotlin.reflect.KClass

class CountryViewModelFactory(private val repository: CountryRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return CountryViewModel(repository) as T
    }
}
