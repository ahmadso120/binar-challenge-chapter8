package com.sopian.challenge7.ui.photodetail

import android.icu.text.CaseMap
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.material3.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sopian.challenge7.domain.model.photodetail.UnsplashImageDetail

@Composable
fun PhotoDetailScreen(
    photoId: String,
    upPress: () -> Unit,
    viewModel: PhotoDetailViewModel = hiltViewModel()
) {
    viewModel.getPhotoDetail(photoId)
    val photoDetail by viewModel.uiState.collectAsState()

    PhotoDetails(
        photoDetail = photoDetail,
        upPress = upPress
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoDetails(
    photoDetail: PhotoDetailUiState,
    upPress: () -> Unit
) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { photoDetail.data?.user?.username?.let {
                    Text(text = it)
                } },
                navigationIcon = {
                    IconButton(onClick = { upPress.invoke() }) {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        },
        content = { innerPadding ->
            photoDetail.data?.let { data ->
                val painter = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(data.urls.regular)
                        .crossfade(300)
                        .placeholder(com.sopian.challenge7.R.drawable.ic_placeholder)
                        .build()
                )
                Box(
                    modifier = Modifier
                        .padding(innerPadding)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Image(
                        modifier = Modifier.fillMaxSize(),
                        painter = painter,
                        contentDescription = "Unsplash Image",
                        contentScale = ContentScale.Crop
                    )
                    Surface(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .alpha(0.60f),
                        color = Color.Black
                    ) {}
                    Row(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                            .padding(horizontal = 6.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = buildAnnotatedString {
                                append("Camera ")
                                withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                                    data.exif.name?.let {
                                        append(it)
                                    }
                                }
                            },
                            color = Color.White,
                            fontSize = MaterialTheme.typography.labelMedium.fontSize,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
            }
        }
    )
}