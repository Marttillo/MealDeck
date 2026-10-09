package com.martillo.mealdeck



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.martillo.mealdeck.ui.MealDeckApp
import com.martillo.mealdeck.ui.theme.MealDeckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            MealDeckTheme {
                MealDeckApp()

            }
        }
    }
}

