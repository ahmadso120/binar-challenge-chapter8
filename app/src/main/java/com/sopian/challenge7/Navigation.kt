package com.sopian.challenge7

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Search: Screen("search")
    object Favorite: Screen("favorite")
    object PhotoDetail: Screen("photo_detail")
    object Login: Screen("login")
    object SignUp: Screen("sign_up")
}

const val PHOTO_DETAIL_KEY_ID_KEY = "photoId"