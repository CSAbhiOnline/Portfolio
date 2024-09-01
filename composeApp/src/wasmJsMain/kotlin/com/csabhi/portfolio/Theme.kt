package com.csabhi.portfolio

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
// light theme colors
val LightPrimaryColor = Color(0xFFFFFFFF)
val LightOnPrimaryColor = othercolorlightmode
val LightBackgroundColor = Color(0xfffcfcfc)
val LightOnBackgroundColor = Color(0xFF000000)
val LightTextColor= othercolorlightmode
val LightHeaderColor= othercolorlightmode.copy(alpha = 0.3f)

// dark theme colors
val DarkPrimaryColor = Color(0xFF000000)
val DarkOnPrimaryColor = othercolor
val DarkBackgroundColor = Color(0xFF121212)
val DarkOnBackgroundColor = Color(0xFFFFFFFF)
val DarkTextColor= othercolor
val DarkHeaderColor=Color(0xff000000)




 val LightColorPalette = lightColors(
    primary = LightPrimaryColor,
    onPrimary = LightOnPrimaryColor,
    background = LightBackgroundColor,
    onBackground = LightOnBackgroundColor
)

 val DarkColorPalette = darkColors(
    primary = DarkPrimaryColor,
    onPrimary = DarkOnPrimaryColor,
    background = DarkBackgroundColor,
    onBackground = DarkOnBackgroundColor
)
@Composable
fun PortfolioTheme(
                   content:@Composable ()-> Unit
){
    val colors= darkColors()
    MaterialTheme(colors = colors,content=content)

}
