/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.ui.screens.Home
import com.example.androiddevchallenge.ui.screens.Login
import com.example.androiddevchallenge.ui.screens.Welcome
import com.example.androiddevchallenge.ui.theme.Theme
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets

object Routes {
    const val WELCOME = "welcome"
    const val LOGIN = "login"
    const val HOME = "home"
}

@Composable
fun App() {
    ProvideWindowInsets {
        Theme {
            val navController = rememberNavController()
            NavHost(navController, startDestination = Routes.WELCOME) {
                composable(Routes.WELCOME) { Welcome(navController = navController) }
                composable(Routes.LOGIN) { Login(navController = navController) }
                composable(Routes.HOME) { Home() }
            }
        }
    }
}
