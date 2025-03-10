package com.deivitdev.cat.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.deivitdev.cat.Colors
import com.deivitdev.cat.model.CatApi
import com.deivitdev.cat.viewmodel.CatViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }

    val viewModel: CatViewModel = viewModel { CatViewModel(CatApi(client)) }
    val imageUrl by viewModel.images.collectAsState()
    val fact by viewModel.fact.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    var selectedImageUrl by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()


    MaterialTheme {
        val snackbarHostState = remember { SnackbarHostState() }
        Scaffold(
            snackbarHost = {
                SnackbarHost(snackbarHostState) { data ->
                    Snackbar(
                        backgroundColor = Color(0xFF0f5c0e),
                        contentColor = Colors.white,
                        snackbarData = data
                    )
                }
            },
            topBar = {
                TopAppBar(
                    backgroundColor = Colors.white,
                    contentColor = Colors.black,
                    contentPadding = PaddingValues(8.dp, 0.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("Cat Fact & Cat Image", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                        IconButton(onClick = {
                            viewModel.loadCatData()
                            coroutineScope.launch {
                                snackbarHostState.showSnackbar(
                                    "Datos recargados", duration = SnackbarDuration.Short
                                )
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Refresh, contentDescription = "Menu"
                            )
                        }
                    }
                }
            },
        ) {
            Surface(modifier = Modifier.fillMaxSize(), color = Colors.white) {
                CatScreen(
                    isLoading = isLoading,
                    imageUrl = imageUrl,
                    fact = fact,
                    selectedImageUrl = selectedImageUrl,
                    onImageSelected = { url -> selectedImageUrl = url },
                    onDismissImage = { selectedImageUrl = null },
                )
            }
        }
    }

    LaunchedEffect(true) {
        viewModel.loadCatData()
    }
}




