package com.github.jesuserro.helloworldkmp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import helloworldkmp.composeapp.generated.resources.Res
import helloworldkmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun appState(): Triple<List<Country>, String, MutableState<Boolean>> {
    val countries by produceState<List<Country>>(initialValue = emptyList()) {
        val repository = InMemoryCountryRepository()
        value = repository.getCountries()
    }
    val greeting = remember { Greeting().greet() }
    val showContent = remember { mutableStateOf(false) }

    return Triple(countries, greeting, showContent)
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun App() {
    val (countries, greeting, showContent) = appState()

    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("${countries.size} countries") })
            }
        ) { padding ->
            LazyColumn(Modifier.padding(padding)) {
                items(countries) { country ->
                    ListItem {
                        Text("${country.emoji} ${country.name} (${country.code})")
                    }
                }
            }

            Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                Button(onClick = { showContent.value = !showContent.value }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent.value) {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
            }
        }
    }
}