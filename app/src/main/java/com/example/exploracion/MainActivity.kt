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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Scaffold(
                topBar = { CenterAlignedTopAppBar(title = { Text("Exploración: Contenedores") }) }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    SeccionContenedores()
                    Spacer(modifier = Modifier.height(20.dp))
                    ContenedoresRestantes()
                }
            }
        }
    }
}

@Composable
fun SeccionContenedores() {
    Text("1. SURFACE", style = MaterialTheme.typography.titleMedium)
    Surface(modifier = Modifier.fillMaxWidth().height(60.dp), color = Color(0xFFEADDFF), shadowElevation = 4.dp) {
        Text("Superficie con elevación", Modifier.padding(8.dp))
    }

    Spacer(modifier = Modifier.height(16.dp))
    Text("2. LAZY COLUMN", style = MaterialTheme.typography.titleMedium)
    Box(modifier = Modifier.height(100.dp)) {
        LazyColumn { items(3) { i -> Text("Elemento lista $i") } }
    }

    Spacer(modifier = Modifier.height(16.dp))
    Text("3. LAZY ROW", style = MaterialTheme.typography.titleMedium)
    LazyRow {
        items(5) { i ->
            Box(Modifier.size(50.dp).background(Color.Cyan).padding(4.dp)) { Text("$i") }
        }
    }

    Spacer(modifier = Modifier.height(16.dp))
    Text("4. GRID", style = MaterialTheme.typography.titleMedium)
    Box(modifier = Modifier.height(100.dp)) {
        LazyVerticalGrid(columns = GridCells.Fixed(3)) {
            items(3) { i -> Card(Modifier.padding(4.dp)) { Text("Item $i", Modifier.padding(8.dp)) } }
        }
    }
}

@Composable
fun ContenedoresRestantes() {
    Text("5. BOX (Apilamiento)", style = MaterialTheme.typography.titleMedium)
    Box(modifier = Modifier.size(100.dp).background(Color.LightGray), contentAlignment = Alignment.Center) {
        Text("Centro")
    }

    Spacer(modifier = Modifier.height(16.dp))
    Text("6. ROW (Fila simple)", style = MaterialTheme.typography.titleMedium)
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Button(onClick = {}) { Text("Btn 1") }
        Button(onClick = {}) { Text("Btn 2") }
    }
}