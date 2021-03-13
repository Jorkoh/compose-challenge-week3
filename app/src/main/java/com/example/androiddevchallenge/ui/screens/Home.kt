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
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.Elevations
import com.example.androiddevchallenge.ui.theme.Theme
import com.example.androiddevchallenge.ui.theme.greenCustom
import com.example.androiddevchallenge.ui.theme.redCustom

@Composable
fun Home() {
    HomeContent()
}

@Composable
fun HomeContent() {
    Surface(color = MaterialTheme.colors.background) {
        BottomSheetScaffold(
            sheetShape = RoundedCornerShape(0.dp),
            sheetPeekHeight = 64.dp,
            sheetContent = { BottomSheetContent() }
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TabSelector()
                Text(
                    "Balance",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .paddingFromBaseline(top = 32.dp, bottom = 8.dp)
                        .padding(horizontal = 16.dp)
                )
                Text(
                    "$73,589.01",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .paddingFromBaseline(top = 48.dp, bottom = 24.dp)
                        .padding(horizontal = 16.dp)
                )
                Text(
                    "+412.35 today",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.greenCustom,
                    modifier = Modifier
                        .paddingFromBaseline(top = 16.dp, bottom = 32.dp)
                        .padding(horizontal = 16.dp)
                )
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
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    Text(
                        "TRANSACT",
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary,
                    )
                }
                Spacer(Modifier.height(16.dp))
                GraphType()
                Spacer(Modifier.height(16.dp))
                Image(
                    painter = painterResource(R.drawable.ic_home_illos),
                    contentDescription = null
                )
                Spacer(
                    Modifier
                        .height(32.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        }
    }
}

@Composable
fun TabSelector() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            "ACCOUNT",
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.paddingFromBaseline(top = 64.dp, bottom = 8.dp)
        )
        Text(
            "WATCHLIST",
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
            modifier = Modifier.paddingFromBaseline(top = 64.dp, bottom = 8.dp)
        )
        Text(
            "PROFILE",
            style = MaterialTheme.typography.button,
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.5f),
            modifier = Modifier.paddingFromBaseline(top = 64.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun GraphType() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        Spacer(Modifier.width(8.dp))
        GraphTypeItem(name = "Week", dropDown = true)
        GraphTypeItem(name = "ETFs")
        GraphTypeItem(name = "Stocks")
        GraphTypeItem(name = "Funds")
        GraphTypeItem(name = "Currencies")
        GraphTypeItem(name = "Markets")
        Spacer(Modifier.width(8.dp))
    }
}

@Composable
fun GraphTypeItem(name: String, dropDown: Boolean = false) {
    OutlinedButton(
        onClick = { },
        colors = ButtonDefaults.outlinedButtonColors(
            backgroundColor = MaterialTheme.colors.background
        ),
        elevation = ButtonDefaults.elevation(
            Elevations.buttonElevation,
            Elevations.buttonElevation,
            Elevations.buttonElevation
        ),
        border = BorderStroke(
            ButtonDefaults.OutlinedBorderSize,
            MaterialTheme.colors.onBackground
        ),
        shape = MaterialTheme.shapes.large,
        modifier = Modifier.height(40.dp),
    ) {
        Text(
            name,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 32.dp)
        )
        if (dropDown) {
            Spacer(modifier = Modifier.width(4.dp))
            Icon(
                imageVector = Icons.Outlined.ExpandMore,
                contentDescription = null,
                modifier = Modifier.size(16.dp),
                tint = MaterialTheme.colors.onBackground
            )
        }
    }
}

@Composable
fun BottomSheetContent() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            item {
                Text(
                    "Positions",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.paddingFromBaseline(top = 40.dp, bottom = 24.dp)
                )
            }
            items(positions) { position ->
                Divider(color = MaterialTheme.colors.onSurface)
                PositionItem(position)
            }
        }
    )
}

@Composable
fun PositionItem(item: Item) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .height(56.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                item.price,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.paddingFromBaseline(top = 24.dp)
            )
            Text(
                item.change,
                style = MaterialTheme.typography.body1,
                color = if (item.changeDirection == ChangeDirection.Positive) {
                    MaterialTheme.colors.greenCustom
                } else {
                    MaterialTheme.colors.redCustom
                },
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp)
            )
        }
        Spacer(Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ) {
            Text(
                item.symbol,
                style = MaterialTheme.typography.h3,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.paddingFromBaseline(top = 24.dp)
            )
            Text(
                item.name,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 16.dp)
            )
        }
        Image(
            modifier = Modifier.fillMaxHeight(),
            painter = painterResource(id = item.imageRes),
            contentDescription = null,
        )
    }
}

enum class ChangeDirection {
    Positive, Negative
}

data class Item(
    val imageRes: Int,
    val symbol: String,
    val name: String,
    val price: String,
    val change: String,
    val changeDirection: ChangeDirection
)

val positions = listOf(
    Item(
        imageRes = R.drawable.ic_home_alk,
        symbol = "ALK",
        name = "Alaska Air Group, Inc.",
        price = "$7,918",
        change = "-0.54%",
        changeDirection = ChangeDirection.Negative
    ),
    Item(
        imageRes = R.drawable.ic_home_ba,
        symbol = "BA",
        name = "Boeing Co.",
        price = "$1,293",
        change = "+4.18%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_dal,
        symbol = "DAL",
        name = "Delta Airlines Inc.",
        price = "$893.50",
        change = "-0.54%",
        changeDirection = ChangeDirection.Negative
    ),
    Item(
        imageRes = R.drawable.ic_home_exp,
        symbol = "EXPE",
        name = "Expedia Group Inc.",
        price = "$12,301",
        change = "+2.51%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_eadsy,
        symbol = "EADSY",
        name = "Airbus SE",
        price = "$12,301",
        change = "+1.38%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_jblu,
        symbol = "JBLU",
        name = "Jetblue Airways Corp.",
        price = "$8,521",
        change = "+1.56%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_mar,
        symbol = "MAR",
        name = "Marriott International Inc.",
        price = "$521",
        change = "+2.75%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_ccl,
        symbol = "CCL",
        name = "Carnival Corp",
        price = "$5,481",
        change = "+0.14%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_rcl,
        symbol = "RCL",
        name = "Royal Caribbean Cruises",
        price = "$9,184",
        change = "+1.69%",
        changeDirection = ChangeDirection.Positive
    ),
    Item(
        imageRes = R.drawable.ic_home_trvl,
        symbol = "TRVL",
        name = "Travelocity Inc.",
        price = "$654",
        change = "+3.23%",
        changeDirection = ChangeDirection.Positive
    ),
)

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    Theme {
        HomeContent()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    Theme(darkTheme = true) {
        HomeContent()
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun PositionsLightPreview() {
    Theme {
        Surface {
            BottomSheetContent()
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun PositionsDarkPreview() {
    Theme(darkTheme = true) {
        Surface {
            BottomSheetContent()
        }
    }
}
