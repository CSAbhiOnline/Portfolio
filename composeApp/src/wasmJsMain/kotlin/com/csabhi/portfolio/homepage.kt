package com.csabhi.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource

import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform

@Composable
fun homepage() {
    MaterialTheme {
        /*var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
        var isvisible by remember {
            mutableStateOf(false)
        }
        val imageoffset by animateFloatAsState(targetValue = if (isvisible) -50f else 0f, animationSpec = tween(500))

        Box(Modifier.fillMaxSize().background(themebrush)){
            Column(Modifier.fillMaxWidth().padding(0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.fillMaxWidth().background(Color.Transparent).padding(0.dp).shadow(elevation = 5.dp, spotColor = othercolor, ambientColor = othercolor)){
                    Text("Welcome", style = TextStyle(
                        fontSize = TextUnit.Unspecified,
                        color = black,
                        fontFamily = FontFamily.Serif
                    ))
                }
                Row (Modifier.fillMaxWidth().weight(1f).background(Color.Transparent), horizontalArrangement = Arrangement.Center){
                    Image(painterResource(Res.drawable.compose_multiplatform), null,Modifier.clickable { isvisible=!isvisible }.offset(x=imageoffset.dp))
                    AnimatedVisibility(
                        visible = isvisible,
                        enter = fadeIn(animationSpec = tween(500)),
                        exit = fadeOut(animationSpec = tween(500)),modifier=Modifier.weight(1f)
                    ){
                        Text("This Website is totaly made using Kotlin", color = Color.White,modifier=Modifier.fillMaxWidth())
                    }

                }

            }

        }
    }
}