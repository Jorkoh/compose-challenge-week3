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
package com.example.androiddevchallenge.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.Routes
import com.example.androiddevchallenge.ui.theme.Colors
import com.example.androiddevchallenge.ui.theme.Elevations
import com.example.androiddevchallenge.ui.theme.Theme

@Composable
fun Welcome(navController: NavHostController) {
    WelcomeContent(onLoginClicked = { navController.navigate(Routes.LOGIN) })
}

@Composable
fun WelcomeContent(
    onLoginClicked: () -> Unit
) {
    Surface(color = MaterialTheme.colors.background) {
        Box {
            // Background image
            Image(
                painter = painterResource(R.drawable.ic_welcome_bg),
                modifier = Modifier.fillMaxSize(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            // Content
            Box(modifier = Modifier.fillMaxSize()) {
                Image(
                    painter = painterResource(R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                        .align(Alignment.BottomCenter)
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = MaterialTheme.colors.primary
                        ),
                        shape = MaterialTheme.shapes.large,
                        elevation = ButtonDefaults.elevation(
                            Elevations.buttonElevation,
                            Elevations.buttonElevation,
                            Elevations.buttonElevation
                        ),
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f),
                    ) {
                        Text(
                            "GET STARTED",
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }
                    OutlinedButton(
                        onClick = onLoginClicked,
                        colors = ButtonDefaults.outlinedButtonColors(
                            backgroundColor = Colors.purple
                        ),
                        elevation = ButtonDefaults.elevation(
                            Elevations.buttonElevation,
                            Elevations.buttonElevation,
                            Elevations.buttonElevation
                        ),
                        border = BorderStroke(
                            ButtonDefaults.OutlinedBorderSize,
                            MaterialTheme.colors.primary
                        ),
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier
                            .height(48.dp)
                            .weight(1f),
                    ) {
                        Text(
                            "LOG IN",
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.primary,
                        )
                    }
                }
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview() {
    Theme {
        WelcomeContent {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview() {
    Theme(darkTheme = true) {
        WelcomeContent {}
    }
}
