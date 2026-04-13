package com.example.exploracion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // SCAFFOLD: Contenedor de alto nivel que organiza la estructura básica (TopBar, Fab, etc.)
            Scaffold(
                topBar = { CenterAlignedTopAppBar(title = { Text("Exploración: Contenedores") }) }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()) // Permite scroll si el contenido crece
                ) {
                    SeccionContenedores()
                }
            }
        }
    }
}

@Composable
fun SeccionContenedores() {
    Text("1. SURFACE", style = MaterialTheme.typography.titleMedium)
    Surface(
        modifier = Modifier.fillMaxWidth().height(60.dp),
        color = Color(0xFFEADDFF),
        shadowElevation = 4.dp
    ) { Text("Superficie con elevación y color", Modifier.padding(8.dp)) }

    Spacer(modifier = Modifier.height(20.dp))

    Text("2. LAZY COLUMN (Lista Vertical)", style = MaterialTheme.typography.titleMedium)
    Box(modifier = Modifier.height(100.dp)) {
        LazyColumn {
            items(5) { i -> Text("Elemento de lista $i", Modifier.padding(4.dp)) }
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    Text("3. LAZY ROW (Lista Horizontal)", style = MaterialTheme.typography.titleMedium)
    LazyRow {
        items(10) { i ->
            Box(Modifier.size(50.dp).padding(4.dp).background(Color.Cyan)) { Text("$i") }
        }
    }

    Spacer(modifier = Modifier.height(20.dp))

    Text("4. GRID (Cuadrícula)", style = MaterialTheme.typography.titleMedium)
    Box(modifier = Modifier.height(120.dp)) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(6) { i ->
                Card(Modifier.padding(4.dp)) { Text("Item $i", Modifier.padding(8.dp)) }
            }
        }
    }
}