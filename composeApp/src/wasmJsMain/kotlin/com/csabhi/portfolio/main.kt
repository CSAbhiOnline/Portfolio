package com.csabhi.portfolio

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ComposeViewport
import androidx.compose.ui.window.Popup
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.compose_multiplatform
import portfolio.composeapp.generated.resources.square
@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {

            homepage()


    }
}
fun getscreenheight(): Float {
    return window.innerHeight.toFloat()
}
fun getscreenwidth(): Float {
    return window.innerWidth.toFloat()
}
@Composable
fun homepage(){
    val heightofscreen= getscreenheight()
    val widthofscreen= getscreenwidth()




    var isdarkmode by remember{
        mutableStateOf(true)
    }

    val darkColors = darkColors(
    primary = DarkPrimaryColor,
    onPrimary = DarkOnPrimaryColor,
    background = DarkBackgroundColor,
    onBackground = DarkOnBackgroundColor
)

    val lightColors = lightColors(
        primary = LightPrimaryColor,
        onPrimary = LightOnPrimaryColor,
        background = LightBackgroundColor,
        onBackground = LightOnBackgroundColor
    )
    val colors = if (isdarkmode) darkColors else lightColors
    val backgroundColor by animateColorAsState(
        targetValue = colors.background,
        animationSpec = tween(durationMillis = 1000) // Animation duration in milliseconds
    )

    val primaryColor by animateColorAsState(
        targetValue = colors.primary,
        animationSpec = tween(durationMillis = 1000)
    )

    val onPrimaryColor by animateColorAsState(
        targetValue = colors.onPrimary,
        animationSpec = tween(durationMillis = 1000)
    )

    val onBackgroundColor by animateColorAsState(
        targetValue = colors.onBackground,
        animationSpec = tween(durationMillis = 1000)
    )





















    PortfolioTheme() {
        Box(Modifier.fillMaxSize().background(backgroundColor)){
            Column(Modifier.fillMaxWidth().padding(0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.fillMaxWidth().background(primaryColor).clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
                    .drawBehind {
                        val strokeWidth =4.dp.toPx() // Thickness of the border
                        val y = size.height - strokeWidth / 2
                        drawLine(
                            color = onPrimaryColor,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = strokeWidth
                        )
                    }
                ){
                    Row(Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically){
                        Text("Welcome", style = TextStyle(
                            fontSize = (widthofscreen*0.04f).sp,
                            color = onPrimaryColor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.padding(horizontal = (widthofscreen*0.06f).dp, vertical = (heightofscreen*0.03f).dp).wrapContentSize()
                        )
                        Spacer(Modifier.weight(1f))


                        Text("Projects", style = TextStyle(
                            fontSize = (widthofscreen*0.02f).sp,
                            color = onPrimaryColor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.wrapContentSize().padding(horizontal = (widthofscreen*0.03f).dp))


                        Text("About", style = TextStyle(
                            fontSize = (widthofscreen*0.02f).sp,
                            color = onPrimaryColor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.wrapContentSize().padding(horizontal = (widthofscreen*0.03f).dp)
                        )

                    }

                }
                val imageVector =if(isdarkmode) Icons.Filled.ArrowForward else Icons.Filled.ArrowBack



                IconButton(onClick = {
                    isdarkmode=!isdarkmode


                }, modifier = Modifier.align(Alignment.End).wrapContentSize()){

                    Crossfade(targetState = imageVector, animationSpec = tween(500)){
                        Icon(imageVector=it, contentDescription = "", tint = onPrimaryColor, modifier = Modifier.wrapContentSize())
                    }

                    /*if (isdarkmode){
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "", tint = onPrimaryColor)

                        //Image(painter = painterResource(Res.drawable.compose_multiplatform),"")
                        *//*Text("isdarkmode=true", color = onPrimaryColor, style = TextStyle(
                            shadow = Shadow(
                                color = onPrimaryColor,
                                offset = Offset(2f,2f),
                                blurRadius = 5f
                            )
                        ))*//*

                    }
                    else{
                        *//*Text("isdarkmode=false",color = onPrimaryColor,style = TextStyle(
                            shadow = Shadow(
                                color = onPrimaryColor,
                                offset = Offset(2f,2f),
                                blurRadius = 5f
                            )))*//*
                        Icon(imageVector = Icons.Filled.ArrowForward, contentDescription = "", tint = onPrimaryColor)
                    }*/
                }


            }

        }
    }
}