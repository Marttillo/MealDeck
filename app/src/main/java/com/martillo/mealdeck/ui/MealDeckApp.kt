package com.martillo.mealdeck.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ListAlt
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Dining
import androidx.compose.material.icons.filled.DinnerDining
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.martillo.mealdeck.App
import com.martillo.mealdeck.ui.home.HomeScreen
import com.martillo.mealdeck.ui.home.HomeState
import com.martillo.mealdeck.ui.theme.MealDeckTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MealDeckApp() {
    val snackbars = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context= LocalContext.current
    val app = LocalContext.current.applicationContext as App
    val barItems = listOf(
        "Home" to Icons.Filled.Home,
        "Recipes" to Icons.Filled.DinnerDining,
        "Diary" to Icons.Filled.Dining,
        "Plan" to Icons.Filled.CalendarMonth,
        "Shopping" to Icons.AutoMirrored.Filled.ListAlt

    )
    var selectedItem by remember { mutableIntStateOf(0) }


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets(),
        snackbarHost = { SnackbarHost(snackbars) },
        bottomBar = {
            NavigationBar {
                barItems.forEachIndexed { index,(label,icon)->
                    NavigationBarItem(
                        icon={Icon(icon, contentDescription = label)},
                        label = {Text(label)},
                        selected = index == selectedItem,
                        onClick = {
                            selectedItem = index

                        }

                    )
                }
            }
        }
    ) { outerPadding ->
        Box(Modifier.padding(outerPadding).fillMaxSize())
        {
           when(barItems.get(selectedItem).first) {
                "Home"->{
                    val homeState = HomeState(
                        kcal = 1800.0,
                        targetKcal = 2000.0,
                        carbs = 100.0,
                        targetCarbs = 200.0,
                        protein = 100.0,
                        targetProtein = 200.0,
                        fat = 100.0,
                        targetFat = 200.0,
                        sugar = 100.0,
                        targetSugar = 200.0
                    )
                    HomeScreen(
                        homeState,

                        onChangeTargets = {
                            scope.launch {
                                snackbars.showSnackbar("Change targets")
                            }
                        },
                    )
                }
                "Recipes"->RecipesScreen()
                "Diary"->DiaryScreen(repository = app.searchRepository)
                "Plan"->PlanScreen()
                "Shopping"->ShopScreen()
            }
        }


    }
}
fun target() {

}

@Composable
fun Greeting(name: String, ) {
    Text(
        text = "Hello $name!",

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealDeckTheme {
        Greeting("Android")
    }
}