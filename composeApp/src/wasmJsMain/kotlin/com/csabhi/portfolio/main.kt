package com.csabhi.portfolio

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValueAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
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
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.platform.LocalViewConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.compose.ui.window.ComposeViewport
import androidx.compose.ui.window.Popup
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import portfolio.composeapp.generated.resources.GothamBold
import portfolio.composeapp.generated.resources.GothamLight
import portfolio.composeapp.generated.resources.GothamMedium
import portfolio.composeapp.generated.resources.Res
import portfolio.composeapp.generated.resources.android_logo_wink
import portfolio.composeapp.generated.resources.android_studio_logo
import portfolio.composeapp.generated.resources.compose_multiplatform
import portfolio.composeapp.generated.resources.compose_multiplatform_logo
import portfolio.composeapp.generated.resources.dark_mode_night_moon_svgrepo_com
import portfolio.composeapp.generated.resources.javalogo
import portfolio.composeapp.generated.resources.kotlingoodlogo
import portfolio.composeapp.generated.resources.light_mode_svgrepo_com
import portfolio.composeapp.generated.resources.my_photo
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
    onBackground = DarkOnBackgroundColor,
    secondary = DarkTextColor,
    onSecondary = DarkHeaderColor
)

    val lightColors = lightColors(
        primary = LightPrimaryColor,
        onPrimary = LightOnPrimaryColor,
        background = LightBackgroundColor,
        onBackground = LightOnBackgroundColor,
        secondary = LightTextColor,
        onSecondary = LightHeaderColor
    )
    val colors = if (isdarkmode) darkColors else lightColors
    val backgroundColor by animateColorAsState(
        targetValue = colors.background,
        animationSpec = tween(durationMillis = 1000)
    )
val HeaderColor by animateColorAsState(
        targetValue = colors.onSecondary,
        animationSpec = tween(durationMillis = 1000)
    )
val themedTextcolor by animateColorAsState(
        targetValue = colors.secondary,
        animationSpec = tween(durationMillis = 1000)
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
    val techskillsitemlist= listOf(
        techskillsitem("Android Studio", image = Res.drawable.android_studio_logo),
        techskillsitem("Kotlin", image = Res.drawable.kotlingoodlogo),
        techskillsitem("Compose Multiplatform", image = Res.drawable.compose_multiplatform_logo),
        techskillsitem("Java", image = Res.drawable.javalogo)
    )


    PortfolioTheme() {
        Box(Modifier.fillMaxSize().background(backgroundColor)){
            val scrollstatelazycolumn= rememberLazyListState()
            Column(Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp).background(Color.Transparent), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.fillMaxWidth().background(HeaderColor,RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)).clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
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
                            color = themedTextcolor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.padding(horizontal = (widthofscreen*0.06f).dp, vertical = (heightofscreen*0.015f).dp).wrapContentSize()
                        )
                        Spacer(Modifier.weight(1f))


                        Text("Projects", style = TextStyle(
                            fontSize = (widthofscreen*0.02f).sp,
                            color = themedTextcolor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.wrapContentSize().padding(horizontal = (widthofscreen*0.03f).dp))


                        Text("Contact", style = TextStyle(
                            fontSize = (widthofscreen*0.02f).sp,
                            color = themedTextcolor,
                            fontFamily = FontFamily(Font(Res.font.square))
                        ), modifier = Modifier.wrapContentSize().padding(horizontal = (widthofscreen*0.03f).dp)
                        )
                        val iconresource =if(isdarkmode) Res.drawable.light_mode_svgrepo_com else Res.drawable.dark_mode_night_moon_svgrepo_com

                        Button(onClick = {
                            isdarkmode=!isdarkmode
                        },

                            colors = ButtonDefaults.buttonColors(HeaderColor),
                            modifier = Modifier.size((widthofscreen*0.05f).dp).padding((widthofscreen*0.01f).dp), contentPadding = PaddingValues(0.dp)
                        ){
                            Crossfade(targetState = iconresource, animationSpec = tween(500)){
                                Icon(painter = painterResource(it) , contentDescription = "", tint = onPrimaryColor, modifier = Modifier.size((widthofscreen*0.02f).dp))
                            }
                        }



                    }

                }

                LazyColumn(Modifier.fillMaxWidth().wrapContentHeight().background(Color.Transparent), horizontalAlignment = Alignment.Start, contentPadding = PaddingValues(bottom=(widthofscreen*0.5f).dp), state = scrollstatelazycolumn){
                    item {
                        FadeInItem {
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround, verticalAlignment = Alignment.CenterVertically){

                                Column (Modifier.weight(1f).padding(start = (widthofscreen*0.1f).dp, end = (widthofscreen*0.03f).dp), horizontalAlignment = Alignment.Start){
                                    Spacer(modifier = Modifier.height((heightofscreen*0.2f).dp))
                                    Text("Hi, my name is", style = TextStyle(
                                        color = themedTextcolor,
                                        fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                        fontSize = (widthofscreen*0.02f).sp
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
                                    var text= buildAnnotatedString {
                                        append("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, ")
                                        withStyle(style = SpanStyle(
                                            color = themedTextcolor,
                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                            fontSize = (widthofscreen*0.01f).sp
                                        )){
                                            append("I am seeking for job opportunities.")
                                        }

                                    }

                                    Text(text,style = TextStyle(
                                        color = onBackgroundColor.copy(alpha = 0.8f),
                                        fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                        fontSize = (widthofscreen*0.01f).sp), modifier = Modifier.padding(vertical = (heightofscreen*0.02f).dp).wrapContentSize()
                                    )
                                }
                              Image(painter = painterResource(Res.drawable.my_photo),"", modifier = Modifier.size((widthofscreen*0.21f).dp).clip(
                                  CircleShape).weight(1f))



                            }

                        }
                    }
                    item {
                        Spacer(Modifier.height((widthofscreen*0.06f).dp))
                    }
                    item {
                      FadeInItem {
                         Column(
                             modifier = Modifier.fillMaxWidth(),
                             horizontalAlignment = Alignment.CenterHorizontally
                         ) {
                             Column(modifier = Modifier.fillParentMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                                 Text("Tech Skills",style = TextStyle(
                                     color = onBackgroundColor,
                                     fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                     fontSize = (widthofscreen*0.05f).sp
                                 ), modifier = Modifier.padding(vertical = (widthofscreen*0.02f).dp))
var scrollStatelazyrow= rememberLazyListState()
                                 val coroutineScope= rememberCoroutineScope()

                                 LazyRow(
                                     state = scrollStatelazyrow,
                                     modifier = Modifier.fillMaxWidth().wrapContentHeight().draggable(
                                         orientation = Orientation.Horizontal,
                                         state = rememberDraggableState { delta ->
                                             coroutineScope.launch {
                                                 scrollStatelazyrow.scrollBy(-delta)
                                             }
                                         },
                                     ))



                                 {
                                     items(techskillsitemlist){
                                         Card(modifier = Modifier.width((widthofscreen*0.11f).dp).height((widthofscreen*0.11f).dp).padding(horizontal = (widthofscreen*0.01f).dp), shape = RoundedCornerShape(12.dp), backgroundColor = primaryColor, border = BorderStroke(0.5.dp, color = onPrimaryColor))
                                         {
                                             Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
                                                 Image(painter = painterResource(it.image),"kotlin", modifier = Modifier.padding(horizontal=(widthofscreen*0.02f).dp).height((widthofscreen*0.02f).dp))
                                                 Text(it.name,style = TextStyle(
                                                     color = themedTextcolor,
                                                     fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                     fontWeight = FontWeight.Bold,
                                                     fontSize = (widthofscreen*0.013f).sp
                                                 ))
                                             }


                                         }
                                     }



                                 }


                             }

                         }
                      }
                    }


                }



            }

           /* Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(4.dp)
                    .align(Alignment.CenterEnd)
                    .background(Color.Gray)
            ) {
                // Calculate the scroll progress based on the current visible items and total items count
                val firstVisibleItemIndex = scrollstatelazycolumn.firstVisibleItemIndex
                val firstVisibleItemScrollOffset = scrollstatelazycolumn.firstVisibleItemScrollOffset

                // Calculate the scroll progress and normalize it to the range [0, 1]
                val scrollProgress = (firstVisibleItemIndex + firstVisibleItemScrollOffset / scrollstatelazycolumn.layoutInfo.visibleItemsInfo.firstOrNull()?.size?.toFloat()!!) / scrollstatelazycolumn.layoutInfo.totalItemsCount.toFloat()

                // Calculate the height of the indicator based on the visible portion of the list
                val indicatorHeight = 60.dp // Set a fixed height for simplicity
                val maxScrollHeight = 300.dp - indicatorHeight // The range in which the indicator can move

                // Apply the calculated scroll progress to position the indicator
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(indicatorHeight)
                        .offset(y = (scrollProgress * maxScrollHeight)))


            }*/
    }}

}
data class techskillsitem(val name:String,val image:DrawableResource)

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
