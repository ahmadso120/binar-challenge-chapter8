package com.sopian.challenge7.ui.signup

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sopian.challenge7.Screen

@Composable
fun SignUpScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {

        Button(onClick = {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Login.route) {
                    inclusive = true
                }
            }
        }) {
            Icon(
                Icons.Filled.Add,
                contentDescription = "Sign Up",
                modifier = Modifier.size(ButtonDefaults.IconSize)
            )
            Spacer(Modifier.size(ButtonDefaults.IconSpacing))
            Text("Sign up")
        }
    }
}