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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Password
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.Routes
import com.example.androiddevchallenge.ui.theme.Elevations
import com.example.androiddevchallenge.ui.theme.Theme

@Composable
fun Login(navController: NavHostController) {
    LoginContent { navController.navigate(Routes.HOME) }
}

@Composable
fun LoginContent(
    onLoginClicked: () -> Unit
) {
    Surface(color = MaterialTheme.colors.surface) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painterResource(R.drawable.ic_login_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    "Welcome back",
                    style = MaterialTheme.typography.h2,
                    color = MaterialTheme.colors.onBackground,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .paddingFromBaseline(top = 152.dp)
                        .fillMaxWidth(),
                )
            }
            Spacer(Modifier.height(40.dp))
            OutlinedTextField(
                "",
                onValueChange = {},
                placeholder = {
                    Row {
                        Icon(
                            imageVector = Icons.Outlined.MailOutline,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colors.onSurface
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Email address",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp).padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.onPrimary,
                    cursorColor = MaterialTheme.colors.onSurface
                )
            )
            Spacer(Modifier.height(8.dp))
            OutlinedTextField(
                "",
                onValueChange = {},
                placeholder = {
                    Row {
                        Icon(
                            imageVector = Icons.Outlined.Password,
                            contentDescription = null,
                            modifier = Modifier.size(24.dp),
                            tint = MaterialTheme.colors.onSurface
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            "Password",
                            style = MaterialTheme.typography.body1,
                            color = MaterialTheme.colors.onSurface,
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp).padding(horizontal = 16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    backgroundColor = MaterialTheme.colors.onPrimary,
                    cursorColor = MaterialTheme.colors.onSurface
                )
            )
            Spacer(Modifier.height(16.dp))
            Button(
                onClick = onLoginClicked,
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
                    .fillMaxWidth().padding(horizontal = 16.dp),
            ) {
                Text(
                    "LOG IN",
                    style = MaterialTheme.typography.button,
                    color = MaterialTheme.colors.onPrimary,
                )
            }
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginLightPreview() {
    Theme {
        LoginContent {}
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun LoginDarkPreview() {
    Theme(darkTheme = true) {
        LoginContent {}
    }
}
