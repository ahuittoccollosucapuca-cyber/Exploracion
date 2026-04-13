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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Scaffold es el contenedor raíz para TopAppBar y FAB
            Scaffold(
                topBar = { CenterAlignedTopAppBar(title = { Text("Laboratorio Completo") }) },
                floatingActionButton = { FloatingActionButton(onClick = {}) { Icon(Icons.Default.Add, contentDescription = "Add") } }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .padding(innerPadding)
                        .padding(16.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    SeccionContenedores()
                    Divider()
                    SeccionControlesCompletos()
                }
            }
        }
    }
}

@Composable
fun SeccionContenedores() {
    Text("CONTENEDORES", style = MaterialTheme.typography.headlineSmall)
    Surface(modifier = Modifier.fillMaxWidth().height(60.dp), color = Color(0xFFEADDFF), shadowElevation = 4.dp) { Text("Surface", Modifier.padding(8.dp)) }
    Box(modifier = Modifier.height(50.dp).background(Color.LightGray)) { Text("Box", Modifier.align(Alignment.Center)) }
    LazyRow { items(3) { i -> Text("LazyRow $i ", Modifier.padding(8.dp)) } }
}

@Composable
fun SeccionControlesCompletos() {
    Text("CONTROLES (Lista completa)", style = MaterialTheme.typography.headlineSmall)

    // AlertDialog
    var showDialog by remember { mutableStateOf(false) }
    Button(onClick = { showDialog = true }) { Text("Abrir AlertDialog") }
    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog = false }, title = { Text("Alerta") }, text = { Text("¡Hola profesor!") }, confirmButton = { TextButton(onClick = { showDialog = false }) { Text("OK") } })
    }

    Card(modifier = Modifier.fillMaxWidth()) { Text("Card: Contenido protegido", Modifier.padding(16.dp)) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        var checked by remember { mutableStateOf(false) }
        Checkbox(checked = checked, onCheckedChange = { checked = it })
        Text("Checkbox")
    }

    Row(verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = true, onClick = {})
        Text("RadioButton")
    }

    Icon(Icons.Default.Star, contentDescription = "Icon")

    LinearProgressIndicator(modifier = Modifier.fillMaxWidth())

    var sliderValue by remember { mutableStateOf(0.5f) }
    Slider(value = sliderValue, onValueChange = { sliderValue = it })

    var switchValue by remember { mutableStateOf(true) }
    Switch(checked = switchValue, onCheckedChange = { switchValue = it })

    Text("FloatingActionButton y TopAppBar están integrados en el Scaffold.")
}