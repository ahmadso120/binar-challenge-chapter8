package com.sopian.challenge7.ui.common

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.sopian.challenge7.data.source.local.entity.unsplash.UnsplashImageEntity
import com.sopian.challenge7.R
import com.sopian.challenge7.domain.model.UnsplashImage
import com.sopian.challenge7.domain.model.Urls
import com.sopian.challenge7.domain.model.User
import com.sopian.challenge7.domain.model.UserLinks

@Composable
fun ListContent(
    items: LazyPagingItems<UnsplashImage>,
    modifier: Modifier,
    selectPhoto: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(all = 12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(
            items = items,
            key = { unsplashImage ->
                unsplashImage.id
            }
        ) { unsplashImage ->
            unsplashImage?.let {
                UnsplashItem(
                    image = it,
                    selectPhoto = selectPhoto
                )
            }
        }
    }
}

@Composable
fun UnsplashItem(
    image: UnsplashImage,
    selectPhoto: (String) -> Unit
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(image.urls.regular)
            .crossfade(300)
            .placeholder(R.drawable.ic_placeholder)
            .build()
    )
    Box(
        modifier = Modifier
            .clickable {
                selectPhoto(image.id)
            }
            .height(300.dp)
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
                    append("Photo by ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Black)) {
                        append(image.user.username)
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

@Composable
@Preview
fun UnsplashImagePreview() {
    UnsplashItem(
        image = UnsplashImage(
            id = "1",
            urls = Urls(regular = "https://images.unsplash.com/photo-1648737966832-a4a65df3eedc?ixlib=rb-1.2.1&ixid=MnwxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=2072&q=80"),
            likes = 100,
            user = User(username = "Ahmad Sopian", userLinks = UserLinks(html = ""))
        )
    ) {}
}