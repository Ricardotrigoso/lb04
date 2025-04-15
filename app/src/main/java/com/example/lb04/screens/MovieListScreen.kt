package com.example.lb04.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieListScreen() {
    var movies by remember { mutableStateOf(listOf<String>()) }
    var newMovie by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = newMovie,
            onValueChange = { newMovie = it },
            label = { Text("Movie name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                if (newMovie.isNotBlank()) {
                    movies = movies + newMovie
                    newMovie = ""
                }
            },
            modifier = Modifier
                .align(Alignment.End)
                .padding(horizontal = 12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
        ) {
            Text("Add Movie")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(movies) { movie ->
                MovieCard(movieName = movie)
            }
        }
    }
}