package com.deivitdev.cat.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage

@Composable
fun FullScreenImageDialog(imageUrl: String, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Box(contentAlignment = Alignment.Center) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "Imagen de gato en pantalla completa",
                modifier = Modifier.height(300.dp),
                contentScale = ContentScale.Crop
            )
        }
    }
}
