package com.example.responsivedesigncompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HomeConstraintLayout(windowSizeClass: WindowSizeClass) {
    ConstraintLayout(Modifier.fillMaxSize())
    {
        val (cardRed, cardBlue, cardGreen, cardCyan, cardYellow) = createRefs()
        val startGuideCompact = createGuidelineFromStart(0.2f)
        val startGuideExpanded = createGuidelineFromStart(270.dp)

        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .constrainAs(cardRed) {
                top.linkTo(cardBlue.top)
                start.linkTo(cardBlue.end, margin = 50.dp)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Blue)
            .constrainAs(cardBlue) {
                top.linkTo(cardCyan.bottom, margin = 20.dp)
//                when (windowSizeClass.widthSizeClass) {
//                    WindowWidthSizeClass.Compact -> {
//                        start.linkTo(startGuideCompact)
//                    }
//
//                    WindowWidthSizeClass.Expanded -> {
//                        start.linkTo(startGuideExpanded)
//
//                    }
//                }

                top.linkTo(cardYellow.bottom, margin = 20.dp)
                start.linkTo(cardYellow.start, margin = (-70).dp)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Green)
            .constrainAs(cardGreen) {
                top.linkTo(cardYellow.top)
                start.linkTo(parent.start)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan)
            .constrainAs(cardCyan) {
                top.linkTo(cardYellow.top)
                end.linkTo(parent.end)

            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Yellow)
            .constrainAs(cardYellow) {
                bottom.linkTo(parent.bottom)
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(parent.start)
            })

        createHorizontalChain(cardCyan, cardYellow, cardGreen, chainStyle = ChainStyle.Spread)

    }
}