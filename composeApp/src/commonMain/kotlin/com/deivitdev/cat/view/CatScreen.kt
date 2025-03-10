package com.deivitdev.cat.view

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.deivitdev.cat.Colors
import com.deivitdev.cat.model.CatImage

@Composable
fun CatScreen(
    isLoading: Boolean,
    imageUrl: List<CatImage>?,
    fact: String?,
    selectedImageUrl: String?,
    onImageSelected: (String) -> Unit,
    onDismissImage: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize().background(color = Colors.black),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        fact?.let {
            Text(
                it,
                modifier = Modifier.padding(10.dp, 0.dp).fillMaxWidth(),
                fontWeight = FontWeight(700),
                color = Colors.white,
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedContent(
            targetState = isLoading, transitionSpec = {
                fadeIn(animationSpec = tween(150, 150)) togetherWith fadeOut(
                    animationSpec = tween(
                        150
                    )
                ) using SizeTransform { initialSize, targetSize ->
                    if (targetState) {
                        keyframes {
                            // Expand horizontally first.
                            IntSize(targetSize.width, initialSize.height) at 150
                            durationMillis = 300
                        }
                    } else {
                        keyframes {
                            // Shrink vertically first.
                            IntSize(initialSize.width, targetSize.height) at 150
                            durationMillis = 300
                        }
                    }
                }
            }, label = "size transform"
        ) { targetExpanded ->
            if (targetExpanded) {
                Box(modifier = Modifier.height(400.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(modifier = Modifier.height(30.dp).width(30.dp))
                }
            } else {
                GridContent(imageUrl, fact, onImageClick = onImageSelected)
            }
        }
    }

    selectedImageUrl?.let {
        FullScreenImageDialog(imageUrl = it, onDismiss = onDismissImage)
    }
}

@Composable
private fun GridContent(
    imageUrl: List<CatImage>?, fact: String?, onImageClick: (String) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2), contentPadding = PaddingValues(
            start = 12.dp, top = 16.dp, end = 12.dp, bottom = 16.dp
        )
    ) {
        imageUrl?.let {
            items(it.size) { index ->
                val catImage = it[index]
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                        .clickable(onClick = { onImageClick(catImage.url) }),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    AsyncImage(
                        model = catImage.url,
                        contentDescription = "Imagen de gato",
                        modifier = Modifier.width(290.dp).height(290.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
private fun Content(
    imageUrl: List<CatImage>?, fact: String?
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        imageUrl?.let { images ->
            items(images.size) { index ->
                val catImage = images[index]
                Card(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = MaterialTheme.shapes.medium,
                ) {
                    AsyncImage(
                        model = catImage.url,
                        contentDescription = "Imagen de gato",
                        modifier = Modifier.width(290.dp).height(290.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}

@Composable
private fun Title() {
    Text(
        text = "Cat Fact & Cat Image",
        fontSize = 24.sp,
        textAlign = TextAlign.Center,
        color = Colors.white,
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    )
}