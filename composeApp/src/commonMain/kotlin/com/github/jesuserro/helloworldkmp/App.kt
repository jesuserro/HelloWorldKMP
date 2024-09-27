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
import androidx.lifecycle.viewmodel.compose.viewModel
import helloworldkmp.composeapp.generated.resources.Res
import helloworldkmp.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun App(viewModel: CountryViewModel = viewModel(factory = CountryViewModelFactory(InMemoryCountryRepository()))) {
    val countries by viewModel.countries.collectAsState()
    val greeting by viewModel.greeting.collectAsState()
    val showContent by viewModel.showContent.collectAsState()

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
                Button(onClick = { viewModel.toggleShowContent() }) {
                    Text("Click me!")
                }
                AnimatedVisibility(showContent) {
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(Res.drawable.compose_multiplatform), null)
                        Text("Compose: $greeting")
                    }
                }
            }
        }
    }
}