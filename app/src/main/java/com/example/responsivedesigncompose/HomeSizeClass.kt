@file:OptIn(ExperimentalLayoutApi::class)

package com.example.responsivedesigncompose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


//Compact = smartphone vertical
//Medium = table vertical/fold
//Expanded = smartphone horizontal / Tablet horizontal


@Composable
fun HomeSizeClass(windowSizeClass: WindowSizeClass) {

    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Expanded -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ViewTablet()
                TopicsButton()
                MainButton(600.dp)
            }
        }

        WindowWidthSizeClass.Medium -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ViewFold()
                TopicsButton()
                MainButton(300.dp)
            }

        }

        WindowWidthSizeClass.Compact -> {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                ViewSmartphone()
                TopicsButton()
                MainButton()
            }
        }
    }

}


@Composable
fun ViewSmartphone() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "",
            tint = Color.Red,
            modifier = Modifier.size(200.dp)
        )
        Text("Username", fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Button(onClick = {
        }) {
            Text("Enter")

        }


    }
}


@Composable
fun ViewFold() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "",
            tint = Color.Blue,
            modifier = Modifier.size(200.dp)
        )

        Text("Username", fontSize = 50.sp, fontWeight = FontWeight.Bold)
        Button(onClick = {
        }) {
            Text("Enter")

        }

    }
}


@Composable
fun ViewTablet() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "",
            tint = Color.Green,
            modifier = Modifier.size(200.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Text("Username", fontSize = 50.sp, fontWeight = FontWeight.Bold)
            Button(onClick = {
            }) {
                Text("Enter")

            }
        }

    }
}


@Composable
fun TopicsButton() {
    FlowRow(horizontalArrangement = Arrangement.spacedBy(5.dp)) {
        val topics = listOf("Dart", "Kotlin", "Java", "Swift", "C#", "Ruby", "Typescript")
        topics.forEach { topic ->
            OutlinedButton(onClick = {}) {
                Text(topic)
            }
        }
    }
}


@Composable
fun MainButton(size: Dp = 200.dp) {

    OutlinedButton(onClick = {}, modifier = Modifier.width(size)) {

        Text("Hello I'm Button")


    }
}