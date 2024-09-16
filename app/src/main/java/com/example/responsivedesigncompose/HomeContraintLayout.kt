package com.example.responsivedesigncompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun HomeConstraintLayout() {
    ConstraintLayout(Modifier.fillMaxSize())
    {
        val (cardRed, cardBlue, cardGreen, cardCyan, cardYellow) = createRefs()

        Box(modifier = Modifier.size(100.dp) .background(Color.Red).constrainAs(cardRed){})
        Box(modifier = Modifier.size(100.dp) .background(Color.Blue).constrainAs(cardBlue){
            top.linkTo(cardCyan.bottom)
        })
        Box(modifier = Modifier.size(100.dp) .background(Color.Green).constrainAs(cardGreen){
            top.linkTo(cardYellow.top)
            start.linkTo(parent.start)
        })
        Box(modifier = Modifier.size(100.dp) .background(Color.Cyan).constrainAs(cardCyan){
            top.linkTo(cardYellow.top)
            end.linkTo(parent.end)

        })
        Box(modifier = Modifier.size(100.dp) .background(Color.Yellow).constrainAs(cardYellow){
            bottom.linkTo(parent.bottom)
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            start.linkTo(parent.start)
        })

        createHorizontalChain(cardCyan, cardYellow, cardGreen, chainStyle = ChainStyle.Spread)

    }
}