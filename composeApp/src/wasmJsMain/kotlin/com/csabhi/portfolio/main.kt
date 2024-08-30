package com.csabhi.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
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
import portfolio.composeapp.generated.resources.GothamBold
import portfolio.composeapp.generated.resources.GothamMedium
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.android_logo_wink
import portfolio.composeapp.generated.resources.compose_multiplatform
import portfolio.composeapp.generated.resources.dark_mode_night_moon_svgrepo_com
import portfolio.composeapp.generated.resources.light_mode_svgrepo_com
import portfolio.composeapp.generated.resources.square
import kotlin.random.Random

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
@OptIn(ExperimentalFoundationApi::class)
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
            Column(Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
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


                        Text("Contact", style = TextStyle(
                            fontSize = (widthofscreen*0.02f).sp,
                            color = onPrimaryColor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.wrapContentSize().padding(horizontal = (widthofscreen*0.03f).dp)
                        )
                        val iconresource =if(isdarkmode) Res.drawable.light_mode_svgrepo_com else Res.drawable.dark_mode_night_moon_svgrepo_com

                        Button(onClick = {
                            isdarkmode=!isdarkmode
                        },

                            colors = ButtonDefaults.buttonColors(backgroundColor),
                            modifier = Modifier.size((widthofscreen*0.05f).dp).padding((widthofscreen*0.01f).dp), contentPadding = PaddingValues(0.dp)
                        ){
                            Crossfade(targetState = iconresource, animationSpec = tween(500)){
                                Icon(painter = painterResource(it) , contentDescription = "", tint = onPrimaryColor, modifier = Modifier.size((widthofscreen*0.02f).dp))
                            }
                        }



                    }

                }

                LazyColumn(Modifier.fillMaxWidth().wrapContentHeight().background(Color.Transparent), horizontalAlignment = Alignment.CenterHorizontally, contentPadding = PaddingValues(bottom=(widthofscreen*0.5f).dp)){
                    item {
                        FadeInItem {
                            Column (Modifier.fillMaxWidth(0.7f), horizontalAlignment = Alignment.Start){
                                Spacer(modifier = Modifier.height((heightofscreen*0.2f).dp))
                                Text("Hi, my name is", style = TextStyle(
                                    color = onPrimaryColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.017f).sp
                                ),modifier=Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                                Text("Abhinaba Kundu.",style = TextStyle(
                                    color = onBackgroundColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                    fontSize = (widthofscreen*0.05f).sp
                                ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )

                                Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.Start){
                                    Text("I build apps for Android",style = TextStyle(
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                        fontSize = (widthofscreen*0.04f).sp
                                    ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp))

                                    Image(painter = painterResource(Res.drawable.android_logo_wink),"", modifier = Modifier.padding(horizontal = (widthofscreen*0.01f).dp,vertical = (heightofscreen*0.01f).dp).size((widthofscreen*0.04f).dp))
                                }

                                Text("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, I am seeking for job opportunities.",style = TextStyle(
                                    color = onBackgroundColor.copy(alpha = 0.8f),
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.01f).sp), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                            }
                        }
                    }
                    /*item {
                        FadeInItem {
                            Spacer(Modifier.height((widthofscreen*0.5f).dp))
                        }

                    }*/
                    /*item {
                      FadeInItem {
                         Column(
                             modifier = Modifier.fillMaxWidth(),
                             horizontalAlignment = Alignment.CenterHorizontally
                         ) {
                             Text("Tech Skills",style = TextStyle(
                                 color = onBackgroundColor,
                                 fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                 fontSize = (widthofscreen*0.05f).sp
                             ), modifier = Modifier.padding(vertical = (widthofscreen*0.02f).dp))
                         }
                      }
                  }*/

                    item {
                        FadeInItem {
                            Column (Modifier.fillMaxWidth(0.7f), horizontalAlignment = Alignment.Start){
                                Spacer(modifier = Modifier.height((heightofscreen*0.2f).dp))
                                Text("Hi, my name is", style = TextStyle(
                                    color = onPrimaryColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.017f).sp
                                ),modifier=Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                                Text("Abhinaba Kundu.",style = TextStyle(
                                    color = onBackgroundColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                    fontSize = (widthofscreen*0.05f).sp
                                ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )

                                Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.Start){
                                    Text("I build apps for Android",style = TextStyle(
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                        fontSize = (widthofscreen*0.04f).sp
                                    ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp))

                                    Image(painter = painterResource(Res.drawable.android_logo_wink),"", modifier = Modifier.padding(horizontal = (widthofscreen*0.01f).dp,vertical = (heightofscreen*0.01f).dp).size((widthofscreen*0.04f).dp))
                                }

                                Text("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, I am seeking for job opportunities.",style = TextStyle(
                                    color = onBackgroundColor.copy(alpha = 0.8f),
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.01f).sp), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                            }
                        }
                    }
                    item {
                        FadeInItem {
                            Column (Modifier.fillMaxWidth(0.7f), horizontalAlignment = Alignment.Start){
                                Spacer(modifier = Modifier.height((heightofscreen*0.2f).dp))
                                Text("Hi, my name is", style = TextStyle(
                                    color = onPrimaryColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.017f).sp
                                ),modifier=Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                                Text("Abhinaba Kundu.",style = TextStyle(
                                    color = onBackgroundColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                    fontSize = (widthofscreen*0.05f).sp
                                ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )

                                Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.Start){
                                    Text("I build apps for Android",style = TextStyle(
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                        fontSize = (widthofscreen*0.04f).sp
                                    ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp))

                                    Image(painter = painterResource(Res.drawable.android_logo_wink),"", modifier = Modifier.padding(horizontal = (widthofscreen*0.01f).dp,vertical = (heightofscreen*0.01f).dp).size((widthofscreen*0.04f).dp))
                                }

                                Text("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, I am seeking for job opportunities.",style = TextStyle(
                                    color = onBackgroundColor.copy(alpha = 0.8f),
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.01f).sp), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                            }
                        }
                    }
                    item {
                        FadeInItem {
                            Column (Modifier.fillMaxWidth(0.7f), horizontalAlignment = Alignment.Start){
                                Spacer(modifier = Modifier.height((heightofscreen*0.2f).dp))
                                Text("Hi, my name is", style = TextStyle(
                                    color = onPrimaryColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.017f).sp
                                ),modifier=Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                                Text("Abhinaba Kundu.",style = TextStyle(
                                    color = onBackgroundColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                    fontSize = (widthofscreen*0.05f).sp
                                ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )

                                Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.Start){
                                    Text("I build apps for Android",style = TextStyle(
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                        fontSize = (widthofscreen*0.04f).sp
                                    ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp))

                                    Image(painter = painterResource(Res.drawable.android_logo_wink),"", modifier = Modifier.padding(horizontal = (widthofscreen*0.01f).dp,vertical = (heightofscreen*0.01f).dp).size((widthofscreen*0.04f).dp))
                                }

                                Text("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, I am seeking for job opportunities.",style = TextStyle(
                                    color = onBackgroundColor.copy(alpha = 0.8f),
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.01f).sp), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                            }
                        }
                    }
                    item {
                        FadeInItem {
                            Column (Modifier.fillMaxWidth(0.7f), horizontalAlignment = Alignment.Start){
                                Spacer(modifier = Modifier.height((heightofscreen*0.2f).dp))
                                Text("Hi, my name is", style = TextStyle(
                                    color = onPrimaryColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.017f).sp
                                ),modifier=Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                                Text("Abhinaba Kundu.",style = TextStyle(
                                    color = onBackgroundColor,
                                    fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                    fontSize = (widthofscreen*0.05f).sp
                                ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )

                                Row(modifier = Modifier.fillMaxWidth().wrapContentHeight(), horizontalArrangement = Arrangement.Start){
                                    Text("I build apps for Android",style = TextStyle(
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                        fontSize = (widthofscreen*0.04f).sp
                                    ), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp))

                                    Image(painter = painterResource(Res.drawable.android_logo_wink),"", modifier = Modifier.padding(horizontal = (widthofscreen*0.01f).dp,vertical = (heightofscreen*0.01f).dp).size((widthofscreen*0.04f).dp))
                                }

                                Text("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, I am seeking for job opportunities.",style = TextStyle(
                                    color = onBackgroundColor.copy(alpha = 0.8f),
                                    fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                    fontSize = (widthofscreen*0.01f).sp), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                )
                            }
                        }
                    }

                }



            }

        }
    }
}
@Composable
fun FadeInItem(item: @Composable () -> Unit) {
    var isVisible by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 1500)
    )

    // This Box will animate alpha based on visibility
    Box(
        modifier = Modifier
            .alpha(alpha)
            .onGloballyPositioned { coordinates ->
                val viewportHeight = getscreenheight().dp
                val itemTop = coordinates.positionInWindow().y.dp
                val itemBottom = itemTop + coordinates.size.height.dp
                val isVisibleInViewport = itemBottom > 0.dp && itemTop < viewportHeight
                isVisible = isVisibleInViewport
            }
    ) {
        item()
    }
}
