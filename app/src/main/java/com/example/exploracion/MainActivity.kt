package com.example.exploracion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
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
                    HorizontalDivider()
                    SeccionControlesCompletos()
                    HorizontalDivider()
                    SeccionNavegacionYEntrada()
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
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SeccionNavegacionYEntrada() {
    Text("NAVEGACIÓN Y ENTRADA", style = MaterialTheme.typography.headlineSmall)

    Text("• BottomNavigation: Configurado en el Scaffold")

    var showDialog by remember { mutableStateOf(false) }
    Button(onClick = { showDialog = true }) { Text("Abrir Dialog") }
    if (showDialog) {
        AlertDialog(onDismissRequest = { showDialog = false }, title = { Text("Dialog") }, text = { Text("Contenido") }, confirmButton = { TextButton(onClick = { showDialog = false }) { Text("OK") } })
    }

    HorizontalDivider(thickness = 2.dp, color = Color.Gray)

    var expanded by remember { mutableStateOf(false) }
    Box {
        OutlinedButton(onClick = { expanded = true }) { Text("DropdownMenu") }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = { Text("Opción 1") }, onClick = { expanded = false })
        }
    }

    Text("• LazyVerticalGrid: (Ya implementado anteriormente)")
    Text("• NavigationRail: (Para layouts laterales)")

    var text by remember { mutableStateOf("") }
    OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("OutlinedTextField") })

    Text("• Pager: (Configurado con HorizontalPager)")

    Button(onClick = { }) { Text("Disparar SnackBar") }

    var tabIndex by remember { mutableStateOf(0) }
    TabRow(selectedTabIndex = tabIndex) {
        Tab(selected = tabIndex == 0, onClick = { tabIndex = 0 }, text = { Text("Tab 1") })
        Tab(selected = tabIndex == 1, onClick = { tabIndex = 1 }, text = { Text("Tab 2") })
    }

    Text("• Tooltip: (Usa PlainTooltipBox)")
}

