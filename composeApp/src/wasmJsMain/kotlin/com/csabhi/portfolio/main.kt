package com.csabhi.portfolio

import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.darkColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInWindow
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
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
import portfolio.composeapp.generated.resources.candycrush
import portfolio.composeapp.generated.resources.compose_multiplatform_logo
import portfolio.composeapp.generated.resources.dark_mode_night_moon_svgrepo_com
import portfolio.composeapp.generated.resources.facebooklogo
import portfolio.composeapp.generated.resources.firebaselogo
import portfolio.composeapp.generated.resources.github_mark
import portfolio.composeapp.generated.resources.instagralogo
import portfolio.composeapp.generated.resources.iplguru_logo
import portfolio.composeapp.generated.resources.javalogo
import portfolio.composeapp.generated.resources.kotlingoodlogo
import portfolio.composeapp.generated.resources.light_mode_svgrepo_com
import portfolio.composeapp.generated.resources.my_photo
import portfolio.composeapp.generated.resources.mysqllogo
import portfolio.composeapp.generated.resources.pytho_logo
import portfolio.composeapp.generated.resources.python_final_logo
import portfolio.composeapp.generated.resources.redditlogo2436
import portfolio.composeapp.generated.resources.scorexzlogo
import portfolio.composeapp.generated.resources.sendftp
import portfolio.composeapp.generated.resources.spookchat
import portfolio.composeapp.generated.resources.square
import portfolio.composeapp.generated.resources.wallpaper_arena_logo
import portfolio.composeapp.generated.resources.whatsappfinalqr
import portfolio.composeapp.generated.resources.whatsappqr
import portfolio.composeapp.generated.resources.whatsappqrs

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

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun homepage() {
    val heightofscreen = getscreenheight()
    val widthofscreen = getscreenwidth()

    val myimage = painterResource(Res.drawable.my_photo)


    var isdarkmode by remember {
        mutableStateOf(true)
    }
    val coroutineScope = rememberCoroutineScope()

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
    val techskillsitemlist = listOf(
        techskillsitem("Android Studio", image = Res.drawable.android_studio_logo),
        techskillsitem("Kotlin", image = Res.drawable.kotlingoodlogo),
        techskillsitem("Compose Multiplatform", image = Res.drawable.compose_multiplatform_logo),
        techskillsitem("Firebase", image = Res.drawable.firebaselogo),
        techskillsitem("MySQL", image = Res.drawable.mysqllogo),
        techskillsitem("GitHub", image = Res.drawable.github_mark),
        techskillsitem("Java", image = Res.drawable.javalogo),
        techskillsitem("Python", image = Res.drawable.python_final_logo),
    )


    PortfolioTheme() {
        Box(Modifier.fillMaxSize().background(backgroundColor)) {
            val scrollstatelazycolumn = rememberLazyListState()



            Column(
                Modifier.fillMaxWidth().wrapContentHeight().padding(0.dp)
                    .background(Color.Transparent),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(Modifier.fillMaxWidth().background(
                    HeaderColor,
                    RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp)
                ).clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
                    .drawBehind {
                        val strokeWidth = 4.dp.toPx() // Thickness of the border
                        val y = size.height - strokeWidth / 2
                        drawLine(
                            color = onPrimaryColor,
                            start = Offset(0f, y),
                            end = Offset(size.width, y),
                            strokeWidth = strokeWidth
                        )
                    }
                ) {
                    Row(
                        Modifier.fillMaxWidth().wrapContentHeight().background(Color.Transparent),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "Welcome",
                            style = TextStyle(
                                fontSize = (widthofscreen * 0.04f).sp,
                                color = themedTextcolor,
                                fontFamily = FontFamily(Font(Res.font.square))
                            ),
                            modifier = Modifier.padding(
                                horizontal = (widthofscreen * 0.06f).dp,
                                vertical = (heightofscreen * 0.015f).dp
                            ).wrapContentSize()
                        )
                        Spacer(Modifier.weight(1f))

                        Text(
                            "My Skills",
                            style = TextStyle(
                                fontSize = (widthofscreen * 0.01f).sp,
                                color = themedTextcolor,
                                fontFamily = FontFamily(Font(Res.font.square))
                            ),
                            modifier = Modifier.wrapContentSize()
                                .padding(horizontal = (widthofscreen * 0.03f).dp)
                                .clickable {
                                    coroutineScope.launch {
                                        scrollstatelazycolumn.animateScrollToItem(2)
                                    }
                                }
                        )
                        Text(
                            "Projects",
                            style = TextStyle(
                                fontSize = (widthofscreen * 0.01f).sp,
                                color = themedTextcolor,
                                fontFamily = FontFamily(Font(Res.font.square))
                            ),
                            modifier = Modifier.wrapContentSize()
                                .padding(horizontal = (widthofscreen * 0.03f).dp)
                                .clickable {
                                    coroutineScope.launch {
                                        scrollstatelazycolumn.animateScrollToItem(5)
                                    }
                                }
                        )


                        Text(
                            "Contact",
                            style = TextStyle(
                                fontSize = (widthofscreen * 0.01f).sp,
                                color = themedTextcolor,
                                fontFamily = FontFamily(Font(Res.font.square))
                            ),
                            modifier = Modifier.wrapContentSize()
                                .padding(horizontal = (widthofscreen * 0.03f).dp)
                                .clickable {
                                    coroutineScope.launch {
                                        scrollstatelazycolumn.animateScrollToItem(7)
                                    }
                                }
                        )
                        val iconresource =
                            if (isdarkmode) Res.drawable.light_mode_svgrepo_com else Res.drawable.dark_mode_night_moon_svgrepo_com

                        Crossfade(
                            targetState = iconresource,
                            animationSpec = tween(1000),
                            modifier = Modifier.background(
                                Color.Transparent
                            ).padding((widthofscreen * 0.01f).dp)
                        ) {
                            Icon(painter = painterResource(it),
                                contentDescription = "",
                                tint = onPrimaryColor,
                                modifier = Modifier.size((widthofscreen * 0.02f).dp).background(
                                    Color.Transparent
                                ).clickable {
                                    isdarkmode = !isdarkmode
                                })
                        }


                    }

                }

                LazyColumn(
                    Modifier.fillMaxWidth().wrapContentHeight().background(Color.Transparent),
                    horizontalAlignment = Alignment.Start,
                    contentPadding = PaddingValues(bottom = (widthofscreen * 0.25f).dp),
                    state = scrollstatelazycolumn
                ) {
                    //profile image and names part
                    item {
                        FadeInItem {
                            Row(
                                Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceEvenly,
                                verticalAlignment = Alignment.CenterVertically
                            )
                            {

                                Column(
                                    Modifier.fillMaxWidth().weight(1f)
                                        .padding(start = (widthofscreen * 0.1f).dp),
                                    horizontalAlignment = Alignment.Start
                                ) {
                                    Spacer(modifier = Modifier.height((heightofscreen * 0.2f).dp))
                                    Text(
                                        "Hi, my name is",
                                        style = TextStyle(
                                            color = themedTextcolor,
                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                            fontSize = (widthofscreen * 0.02f).sp
                                        ),
                                        modifier = Modifier.padding(vertical = (heightofscreen * 0.02f).dp)
                                            .wrapContentSize()
                                    )
                                    Text(
                                        "Abhinaba Kundu.",
                                        style = TextStyle(
                                            color = onBackgroundColor,
                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                            fontSize = (widthofscreen * 0.05f).sp
                                        ),
                                        modifier = Modifier.padding(vertical = (heightofscreen * 0.02f).dp)
                                            .wrapContentSize()
                                    )

                                    Row(
                                        modifier = Modifier.wrapContentHeight(),
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Text(
                                            "I build apps for Android",
                                            style = TextStyle(
                                                color = onBackgroundColor,
                                                fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                fontSize = (widthofscreen * 0.04f).sp
                                            ),
                                            modifier = Modifier.padding(vertical = (heightofscreen * 0.02f).dp)
                                        )

                                        Image(
                                            painter = painterResource(Res.drawable.android_logo_wink),
                                            "",
                                            modifier = Modifier.padding(
                                                horizontal = (widthofscreen * 0.01f).dp,
                                                vertical = (heightofscreen * 0.01f).dp
                                            ).size((widthofscreen * 0.04f).dp)
                                        )
                                    }
                                    var text = buildAnnotatedString {
                                        append("I am results-oriented and highly motivated recent graduate with a passion for Android development. Adept at leveraging programming skills to create innovative and user-friendly mobile applications. Eager to contribute to a dynamic team and apply academic knowledge in a real-world setting, ")
                                        withStyle(
                                            style = SpanStyle(
                                                color = themedTextcolor,
                                                fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                fontSize = (widthofscreen * 0.01f).sp
                                            )
                                        ) {
                                            append("I am seeking for job opportunities.")
                                        }

                                    }

                                    Text(
                                        text,
                                        style = TextStyle(
                                            color = onBackgroundColor.copy(alpha = 0.8f),
                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                            fontSize = (widthofscreen * 0.01f).sp
                                        ),
                                        modifier = Modifier.padding(vertical = (heightofscreen * 0.02f).dp)
                                            .wrapContentSize()
                                    )

                                    Row(
                                        Modifier.fillMaxWidth().background(Color.Transparent),
                                        horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.03f).dp)
                                    )
                                    {
                                        Button(
                                            onClick = {
                                                window.open(
                                                    "https://docs.google.com/uc?export=download&id=1LAsxzm87i1oFER9h3VqvCi7M4iG7PXOa",
                                                    "_top"
                                                )
                                            },
                                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                                            border = BorderStroke(1.dp, onPrimaryColor),
                                            shape = RoundedCornerShape(12.dp),
                                            modifier = Modifier.width((widthofscreen * 0.1f).dp)
                                                .height((widthofscreen * 0.023f).dp),
                                            contentPadding = PaddingValues(0.dp)
                                        )
                                        {
                                            Box(
                                                Modifier.background(backgroundColor).fillMaxSize(),
                                                contentAlignment = Alignment.Center
                                            )
                                            {
                                                Text(
                                                    "Download CV", style = TextStyle(
                                                        color = themedTextcolor,
                                                        fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                        fontSize = (widthofscreen * 0.01f).sp
                                                    )
                                                )
                                            }

                                        }
                                        Button(
                                            onClick = {
                                                coroutineScope.launch {
                                                    scrollstatelazycolumn.animateScrollToItem(7)
                                                }

                                            },
                                            colors = ButtonDefaults.buttonColors(Color.Transparent),
                                            border = BorderStroke(1.dp, onPrimaryColor),
                                            shape = RoundedCornerShape(12.dp),
                                            modifier = Modifier.width((widthofscreen * 0.1f).dp)
                                                .height((widthofscreen * 0.023f).dp),
                                            contentPadding = PaddingValues(0.dp)
                                        )
                                        {
                                            Box(
                                                Modifier.background(backgroundColor).fillMaxSize(),
                                                contentAlignment = Alignment.Center
                                            )
                                            {
                                                Text(
                                                    "Hire Me!", style = TextStyle(
                                                        color = themedTextcolor,
                                                        fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                        fontSize = (widthofscreen * 0.01f).sp
                                                    )
                                                )
                                            }

                                        }


                                    }
                                }
                                Box(
                                    contentAlignment = Alignment.Center,
                                    modifier = Modifier.weight(1f)
                                ) {
                                    Crossfade(targetState = myimage, animationSpec = tween(1500)) {
                                        Image(
                                            painter = it,
                                            "",
                                            modifier = Modifier.size((widthofscreen * 0.27f).dp)
                                                .clip(
                                                    CircleShape
                                                ),
                                            contentScale = ContentScale.FillWidth
                                        )
                                    }

                                }


                            }

                        }
                    }
                    item {
                        Spacer(Modifier.height((widthofscreen * 0.06f).dp))
                    }
                    //Tech skills part
                    item {
                        FadeInItem {
                            Column(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {

                                Column(
                                    modifier = Modifier.fillParentMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        "Tech Skills",
                                        style = TextStyle(
                                            color = onBackgroundColor,
                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                            fontSize = (widthofscreen * 0.05f).sp
                                        ),
                                        modifier = Modifier.padding(vertical = (widthofscreen * 0.02f).dp)
                                    )

                                    Column(
                                        Modifier.fillMaxWidth()
                                    ) {
                                        techskillsitemlist.chunked(4).forEach { rowof4 ->

                                            Row(
                                                modifier = Modifier.fillMaxWidth()
                                                    .wrapContentHeight(),
                                                horizontalArrangement = Arrangement.Center
                                            ) {
                                                rowof4.forEach {
                                                    var isHovered by remember {
                                                        mutableStateOf(false)
                                                    }
                                                    val scale by animateFloatAsState(
                                                        targetValue = if (isHovered) 1.15f else 1f,
                                                        animationSpec = tween(durationMillis = 300)
                                                    )
                                                    val alpha by animateFloatAsState(
                                                        targetValue = if (isHovered) 0.5f else 0f,
                                                        animationSpec = tween(durationMillis = 300)
                                                    )
                                                    Box(
                                                        modifier = Modifier
                                                            .padding(8.dp) // To give space for the glow effect
                                                    ) {
                                                        // Glow effect background
                                                        Box(
                                                            modifier = Modifier
                                                                .matchParentSize()
                                                                .graphicsLayer {
                                                                    scaleX = scale
                                                                    scaleY = scale
                                                                    this.alpha = alpha
                                                                }
                                                                .background(
                                                                    Brush.radialGradient(
                                                                        listOf(
                                                                            themedTextcolor,
                                                                            backgroundColor
                                                                        )
                                                                    ),
                                                                    shape = RoundedCornerShape(12.dp)
                                                                )
                                                        )

                                                        Card(modifier = Modifier.width((widthofscreen * 0.11f).dp)
                                                            .height((widthofscreen * 0.11f).dp)
                                                            .padding(
                                                                horizontal = (widthofscreen * 0.01f).dp,
                                                                vertical = (widthofscreen * 0.01f).dp
                                                            ).onPointerEvent(
                                                                PointerEventType.Enter
                                                            ) {
                                                                isHovered = true
                                                            }
                                                            .onPointerEvent(PointerEventType.Exit) {
                                                                isHovered = false
                                                            },
                                                            shape = RoundedCornerShape(12.dp),
                                                            backgroundColor = primaryColor,
                                                            border = BorderStroke(
                                                                0.5.dp,
                                                                color = onPrimaryColor
                                                            )
                                                        )
                                                        {
                                                            Column(
                                                                Modifier.fillMaxSize(),
                                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                                verticalArrangement = Arrangement.SpaceEvenly
                                                            ) {
                                                                Image(
                                                                    painter = painterResource(it.image),
                                                                    "kotlin",
                                                                    contentScale = ContentScale.Inside,
                                                                    modifier = Modifier.padding(
                                                                        horizontal = (widthofscreen * 0.009f).dp
                                                                    )
                                                                        .height((widthofscreen * 0.04f).dp)
                                                                )
                                                                Text(
                                                                    it.name, style = TextStyle(
                                                                        color = themedTextcolor,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamBold
                                                                            )
                                                                        ),
                                                                        fontWeight = FontWeight.Bold,
                                                                        fontSize = (widthofscreen * 0.012f).sp,
                                                                        textAlign = TextAlign.Center
                                                                    )
                                                                )
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
                    }
                    item {
                        Spacer(
                            modifier = Modifier.height((widthofscreen * 0.1f).dp).fillMaxWidth()
                                .background(Color.Transparent)
                        )
                    }
                    item {
                        Spacer(
                            modifier = Modifier.height(1.dp).fillMaxWidth()
                                .background(onPrimaryColor)
                        )
                    }

                    //projects part
                    item {
                        FadeInItem {
                            Box(
                                Modifier.fillMaxWidth().wrapContentHeight().background(primaryColor)
                            ) {
                                Column(
                                    Modifier.fillMaxWidth().wrapContentHeight()
                                        .padding(vertical = (widthofscreen * 0.05f).dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Text(
                                        "Projects",
                                        style = TextStyle(
                                            color = onBackgroundColor,
                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                            fontSize = (widthofscreen * 0.05f).sp
                                        ),
                                        modifier = Modifier.padding(vertical = (widthofscreen * 0.02f).dp)
                                    )
val projectsrowscrollstate= rememberLazyListState()
                                    val coroutineScope=rememberCoroutineScope()

                                    LazyRow( state=projectsrowscrollstate, modifier=
                                        Modifier.fillMaxWidth().wrapContentHeight()
                                            .padding(top = (widthofscreen * 0.05f).dp, start = (widthofscreen * 0.01f).dp).draggable(orientation = Orientation.Horizontal, state = rememberDraggableState {
                                                coroutineScope.launch {
                                                    projectsrowscrollstate.scrollBy(-it)
                                                }

                                            }),
                                        horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.06f).dp)
                                    )
                                    {
//scorez
                                        item {
                                            var expand by remember {
                                                mutableStateOf(false)
                                            }
                                            val bullet="\u2022"
                                            val newline="\n"
                                            val size by animateDpAsState(targetValue = if (expand) (widthofscreen * 0.4f).dp else (widthofscreen * 0.18f).dp)
                                            Card(
                                                Modifier.width(size).height(size * 1.2f).clickable {
                                                    expand = !expand
                                                },
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = onPrimaryColor
                                                ),
                                                backgroundColor = primaryColor,
                                                shape = RoundedCornerShape(16.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.fillMaxSize()
                                                        .padding((widthofscreen * 0.008f).dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Image(
                                                        painter = painterResource(Res.drawable.scorexzlogo),
                                                        "",
                                                        modifier = Modifier.size(size / 2)
                                                            .padding((widthofscreen * 0.009f).dp)
                                                    )
                                                    Text(
                                                        "Scorez", style = TextStyle(
                                                            color = themedTextcolor,
                                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            textAlign = TextAlign.Center
                                                        )
                                                    )

                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("A cricket runs scoring app with rich,responsive,modern UI/UX designed to be lightweight and useful companion to gully cricket matches.")
                                                            if (!expand) {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                                        color = onPrimaryColor
                                                                    )
                                                                ) {
                                                                    append("Read more")
                                                                }
                                                            }

                                                        },
                                                        style = TextStyle(
                                                            fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                            color = onBackgroundColor
                                                        ),
                                                        modifier = Modifier.padding(top = (widthofscreen * 0.017f).dp)
                                                    )

                                                    if (expand) {
                                                        Text(
                                                            buildAnnotatedString {
                                                                withStyle(
                                                                    SpanStyle(
                                                                        fontSize = (widthofscreen * 0.015f).sp,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamMedium
                                                                            )
                                                                        ),
                                                                        color = onBackgroundColor,
                                                                        fontWeight = FontWeight.Bold

                                                                    )
                                                                ) {
                                                                    append("Used tech- ")
                                                                }
                                                                append("Kotlin, Jetpack Compose, Android studio")
                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier.padding(top = (widthofscreen * 0.03f).dp)
                                                                .fillMaxWidth()
                                                        )

                                                        Text("Features", style = TextStyle(
                                                            fontSize = (widthofscreen * 0.015f).sp,
                                                            fontFamily = FontFamily(
                                                                Font(
                                                                    Res.font.GothamMedium
                                                                )
                                                            ),
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Bold
                                                        ), modifier = Modifier.padding(vertical = (widthofscreen*0.009f).dp).fillMaxWidth())
                                                        Text(
                                                            buildAnnotatedString {
                                                                append(bullet)
                                                                append(" ")
                                                                append("Track runs, wickets, and overs for both teams.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("See the current Run Rate (CRR).")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Keep it compact - the app is tiny")

                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                        )
                                                    }





                                                }
                                            }
                                        }
                                        //wallpaper arena
                                        item {
                                            var expand by remember {
                                                mutableStateOf(false)
                                            }
                                            val bullet="\u2022"
                                            val newline="\n"
                                            val size by animateDpAsState(targetValue = if (expand) (widthofscreen * 0.4f).dp else (widthofscreen * 0.18f).dp)
                                            Card(
                                                Modifier.width(size).height(size * 1.2f).clickable {
                                                    expand = !expand
                                                },
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = onPrimaryColor
                                                ),
                                                backgroundColor = primaryColor,
                                                shape = RoundedCornerShape(16.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.fillMaxSize()
                                                        .padding((widthofscreen * 0.008f).dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Image(
                                                        painter = painterResource(Res.drawable.wallpaper_arena_logo),
                                                        "",
                                                        modifier = Modifier.size(size / 2)
                                                            .padding((widthofscreen * 0.009f).dp)
                                                    )
                                                    Text(
                                                        "Wallpaper Arena", style = TextStyle(
                                                            color = themedTextcolor,
                                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            textAlign = TextAlign.Center
                                                        )
                                                    )

                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Free HD wallpapers and Backgrounds app with collection of over 10million+ of popular and breathtaking best wallpapers.")
                                                            if (!expand) {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                                        color = onPrimaryColor
                                                                    )
                                                                ) {
                                                                    append("Read more")
                                                                }
                                                            }

                                                        },
                                                        style = TextStyle(
                                                            fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                            color = onBackgroundColor
                                                        ),
                                                        modifier = Modifier.padding(top = (widthofscreen * 0.017f).dp)
                                                    )

                                                    if (expand) {
                                                        Text(
                                                            buildAnnotatedString {
                                                                withStyle(
                                                                    SpanStyle(
                                                                        fontSize = (widthofscreen * 0.015f).sp,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamMedium
                                                                            )
                                                                        ),
                                                                        color = onBackgroundColor,
                                                                        fontWeight = FontWeight.Bold

                                                                    )
                                                                ) {
                                                                    append("Used tech- ")
                                                                }
                                                                append("Java/XML, Retrofit, JSON, Android studio")
                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier.padding(top = (widthofscreen * 0.03f).dp)
                                                                .fillMaxWidth()
                                                        )

                                                        Text("Features", style = TextStyle(
                                                            fontSize = (widthofscreen * 0.015f).sp,
                                                            fontFamily = FontFamily(
                                                                Font(
                                                                    Res.font.GothamMedium
                                                                )
                                                            ),
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Bold
                                                        ), modifier = Modifier.padding(vertical = (widthofscreen*0.009f).dp).fillMaxWidth())
                                                        Text(
                                                            buildAnnotatedString {
                                                                append(bullet)
                                                                append(" ")
                                                                append("Huge collection of over 10mn+ images")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Fetching wallpapers asynchronously using Retrofit library")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Modern user interface designing")

                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                        )
                                                    }





                                                }
                                            }
                                        }
                                        //IPLGuru
                                        item {
                                            var expand by remember {
                                                mutableStateOf(false)
                                            }
                                            val bullet="\u2022"
                                            val newline="\n"
                                            val size by animateDpAsState(targetValue = if (expand) (widthofscreen * 0.4f).dp else (widthofscreen * 0.18f).dp)
                                            Card(
                                                Modifier.width(size).height(size * 1.2f).clickable {
                                                    expand = !expand
                                                },
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = onPrimaryColor
                                                ),
                                                backgroundColor = primaryColor,
                                                shape = RoundedCornerShape(16.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.fillMaxSize()
                                                        .padding((widthofscreen * 0.008f).dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Image(
                                                        painter = painterResource(Res.drawable.iplguru_logo),
                                                        "",
                                                        modifier = Modifier.size(size / 2)
                                                            .padding((widthofscreen * 0.009f).dp)
                                                    )
                                                    Text(
                                                        "IPLGuru", style = TextStyle(
                                                            color = themedTextcolor,
                                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            textAlign = TextAlign.Center
                                                        )
                                                    )

                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("Match winner prediction app using machine learning algorithms trained on vast dataset from 2008")
                                                            if (!expand) {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                                        color = onPrimaryColor
                                                                    )
                                                                ) {
                                                                    append("Read more")
                                                                }
                                                            }

                                                        },
                                                        style = TextStyle(
                                                            fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                            color = onBackgroundColor
                                                        ),
                                                        modifier = Modifier.padding(top = (widthofscreen * 0.017f).dp)
                                                    )

                                                    if (expand) {
                                                        Text(
                                                            buildAnnotatedString {
                                                                withStyle(
                                                                    SpanStyle(
                                                                        fontSize = (widthofscreen * 0.015f).sp,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamMedium
                                                                            )
                                                                        ),
                                                                        color = onBackgroundColor,
                                                                        fontWeight = FontWeight.Bold

                                                                    )
                                                                ) {
                                                                    append("Used tech- ")
                                                                }
                                                                append("Java/XML, Python, ML, scikit-learn, ChaquoPy, Android studio")
                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier.padding(top = (widthofscreen * 0.03f).dp)
                                                                .fillMaxWidth()
                                                        )

                                                        Text("Features", style = TextStyle(
                                                            fontSize = (widthofscreen * 0.015f).sp,
                                                            fontFamily = FontFamily(
                                                                Font(
                                                                    Res.font.GothamMedium
                                                                )
                                                            ),
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Bold
                                                        ), modifier = Modifier.padding(vertical = (widthofscreen*0.009f).dp).fillMaxWidth())
                                                        Text(
                                                            buildAnnotatedString {
                                                                append(bullet)
                                                                append(" ")
                                                                append("Returned 92% accuracy of prediction in IPL 2023")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Leveraging powerful Machine Learning Algorithms")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Model trained on vast dataset from 2008 to 2022")

                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                        )
                                                    }





                                                }
                                            }
                                        }
//candycrush
                                        item {
                                            var expand by remember {
                                                mutableStateOf(false)
                                            }
                                            val bullet="\u2022"
                                            val newline="\n"
                                            val size by animateDpAsState(targetValue = if (expand) (widthofscreen * 0.4f).dp else (widthofscreen * 0.18f).dp)
                                            Card(
                                                Modifier.width(size).height(size * 1.2f).clickable {
                                                    expand = !expand
                                                },
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = onPrimaryColor
                                                ),
                                                backgroundColor = primaryColor,
                                                shape = RoundedCornerShape(16.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.fillMaxSize()
                                                        .padding((widthofscreen * 0.008f).dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Image(
                                                        painter = painterResource(Res.drawable.candycrush),
                                                        "",
                                                        modifier = Modifier.size(size / 2)
                                                            .padding((widthofscreen * 0.009f).dp)
                                                    )
                                                    Text(
                                                        "CandyCrush", style = TextStyle(
                                                            color = themedTextcolor,
                                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            textAlign = TextAlign.Center
                                                        )
                                                    )

                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("A robust surveillance and data exfiltration malware designed to infiltrate and compromise unsuspecting users' systems, Disguised as a harmless game file.")
                                                            if (!expand) {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                                        color = onPrimaryColor
                                                                    )
                                                                ) {
                                                                    append("Read more")
                                                                }
                                                            }

                                                        },
                                                        style = TextStyle(
                                                            fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                            color = onBackgroundColor
                                                        ),
                                                        modifier = Modifier.padding(top = (widthofscreen * 0.017f).dp)
                                                    )

                                                    if (expand) {
                                                        Text(
                                                            buildAnnotatedString {
                                                                withStyle(
                                                                    SpanStyle(
                                                                        fontSize = (widthofscreen * 0.015f).sp,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamMedium
                                                                            )
                                                                        ),
                                                                        color = onBackgroundColor,
                                                                        fontWeight = FontWeight.Bold

                                                                    )
                                                                ) {
                                                                    append("Used tech- ")
                                                                }
                                                                append("Python, PyInstaller")
                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier.padding(top = (widthofscreen * 0.03f).dp)
                                                                .fillMaxWidth()
                                                        )

                                                        Text("Features", style = TextStyle(
                                                            fontSize = (widthofscreen * 0.015f).sp,
                                                            fontFamily = FontFamily(
                                                                Font(
                                                                    Res.font.GothamMedium
                                                                )
                                                            ),
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Bold
                                                        ), modifier = Modifier.padding(vertical = (widthofscreen*0.009f).dp).fillMaxWidth())
                                                        Text(
                                                            buildAnnotatedString {
                                                                append(bullet)
                                                                append(" ")
                                                                append("Employs keylogging to capture all keystrokes entered by the user.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Through webcam hijacking, it covertly records the user's screen activity, providing visual insights into their digital interactions.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Auto-restarts upon system boot.")

                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                        )
                                                    }





                                                }
                                            }
                                        }
                                        //sendFTP
                                        item {
                                            var expand by remember {
                                                mutableStateOf(false)
                                            }
                                            val bullet="\u2022"
                                            val newline="\n"
                                            val size by animateDpAsState(targetValue = if (expand) (widthofscreen * 0.4f).dp else (widthofscreen * 0.18f).dp)
                                            Card(
                                                Modifier.width(size).height(size * 1.2f).clickable {
                                                    expand = !expand
                                                },
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = onPrimaryColor
                                                ),
                                                backgroundColor = primaryColor,
                                                shape = RoundedCornerShape(16.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.fillMaxSize()
                                                        .padding((widthofscreen * 0.008f).dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Image(
                                                        painter = painterResource(Res.drawable.sendftp),
                                                        "",
                                                        modifier = Modifier.size(size / 2)
                                                            .padding((widthofscreen * 0.009f).dp)
                                                    )
                                                    Text(
                                                        "SendFTP", style = TextStyle(
                                                            color = themedTextcolor,
                                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            textAlign = TextAlign.Center
                                                        )
                                                    )

                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("A PowerShell module designed to monitor a specified folder for new files and automatically upload them to an FTP server. This script is particularly useful for scenarios where you need to regularly share files via FTP without manual intervention.")
                                                            if (!expand) {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                                        color = onPrimaryColor
                                                                    )
                                                                ) {
                                                                    append("Read more")
                                                                }
                                                            }

                                                        },
                                                        style = TextStyle(
                                                            fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                            color = onBackgroundColor
                                                        ),
                                                        modifier = Modifier.padding(top = (widthofscreen * 0.017f).dp)
                                                    )

                                                    if (expand) {
                                                        Text(
                                                            buildAnnotatedString {
                                                                withStyle(
                                                                    SpanStyle(
                                                                        fontSize = (widthofscreen * 0.015f).sp,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamMedium
                                                                            )
                                                                        ),
                                                                        color = onBackgroundColor,
                                                                        fontWeight = FontWeight.Bold

                                                                    )
                                                                ) {
                                                                    append("Used tech- ")
                                                                }
                                                                append("PowerShell script")
                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier.padding(top = (widthofscreen * 0.03f).dp)
                                                                .fillMaxWidth()
                                                        )

                                                        Text("Features", style = TextStyle(
                                                            fontSize = (widthofscreen * 0.015f).sp,
                                                            fontFamily = FontFamily(
                                                                Font(
                                                                    Res.font.GothamMedium
                                                                )
                                                            ),
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Bold
                                                        ), modifier = Modifier.padding(vertical = (widthofscreen*0.009f).dp).fillMaxWidth())
                                                        Text(
                                                            buildAnnotatedString {
                                                                append(bullet)
                                                                append(" ")
                                                                append("Monitors a designated folder for new files.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Automatically uploads new files to a specified directory on an FTP server.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Deletes files after successful upload to prevent duplication.")

                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                        )
                                                    }





                                                }
                                            }
                                        }
                                        //spookchat
                                        item {
                                            var expand by remember {
                                                mutableStateOf(false)
                                            }
                                            val bullet="\u2022"
                                            val newline="\n"
                                            val size by animateDpAsState(targetValue = if (expand) (widthofscreen * 0.4f).dp else (widthofscreen * 0.18f).dp)
                                            Card(
                                                Modifier.width(size).height(size * 1.2f).clickable {
                                                    expand = !expand
                                                },
                                                border = BorderStroke(
                                                    width = 2.dp,
                                                    color = onPrimaryColor
                                                ),
                                                backgroundColor = primaryColor,
                                                shape = RoundedCornerShape(16.dp)
                                            ) {
                                                Column(
                                                    modifier = Modifier.fillMaxSize()
                                                        .padding((widthofscreen * 0.008f).dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    Image(
                                                        painter = painterResource(Res.drawable.spookchat),
                                                        "",
                                                        modifier = Modifier.size(size / 2)
                                                            .padding((widthofscreen * 0.009f).dp)
                                                    )
                                                    Text(
                                                        "Spookchat", style = TextStyle(
                                                            color = themedTextcolor,
                                                            fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            textAlign = TextAlign.Center
                                                        )
                                                    )

                                                    Text(
                                                        text = buildAnnotatedString {
                                                            append("A free, open source video chat app implementing user authentication and live video transfer.")
                                                            if (!expand) {
                                                                withStyle(
                                                                    style = SpanStyle(
                                                                        fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                                        color = onPrimaryColor
                                                                    )
                                                                ) {
                                                                    append("Read more")
                                                                }
                                                            }

                                                        },
                                                        style = TextStyle(
                                                            fontSize = if(expand) (widthofscreen * 0.015f).sp else (widthofscreen * 0.01f).sp,
                                                            fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                                            color = onBackgroundColor
                                                        ),
                                                        modifier = Modifier.padding(top = (widthofscreen * 0.017f).dp)
                                                    )

                                                    if (expand) {
                                                        Text(
                                                            buildAnnotatedString {
                                                                withStyle(
                                                                    SpanStyle(
                                                                        fontSize = (widthofscreen * 0.015f).sp,
                                                                        fontFamily = FontFamily(
                                                                            Font(
                                                                                Res.font.GothamMedium
                                                                            )
                                                                        ),
                                                                        color = onBackgroundColor,
                                                                        fontWeight = FontWeight.Bold

                                                                    )
                                                                ) {
                                                                    append("Used tech- ")
                                                                }
                                                                append("Java/XML, WebRTC, Firebase oAuth, Android studio")
                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier.padding(top = (widthofscreen * 0.03f).dp)
                                                                .fillMaxWidth()
                                                        )

                                                        Text("Features", style = TextStyle(
                                                            fontSize = (widthofscreen * 0.015f).sp,
                                                            fontFamily = FontFamily(
                                                                Font(
                                                                    Res.font.GothamMedium
                                                                )
                                                            ),
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Bold
                                                        ), modifier = Modifier.padding(vertical = (widthofscreen*0.009f).dp).fillMaxWidth())
                                                        Text(
                                                            buildAnnotatedString {
                                                                append(bullet)
                                                                append(" ")
                                                                append("Lightweight, bloatware-free, open source alternative to video chat apps.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Fast response and high quality video.")
                                                                append(newline)
                                                                append(bullet)
                                                                append(" ")
                                                                append("Clean, modern user interface to provide best experiences.")

                                                            },
                                                            style = TextStyle(
                                                                fontSize = (widthofscreen * 0.015f).sp,
                                                                fontFamily = FontFamily(Font(Res.font.GothamLight)),
                                                                color = onBackgroundColor,
                                                                fontWeight = FontWeight.Light
                                                            ),
                                                            modifier = Modifier
                                                                .fillMaxWidth()
                                                        )
                                                    }





                                                }
                                            }
                                        }
//see more
                                        item{
                                            Box(modifier = Modifier.wrapContentWidth().padding(top=(widthofscreen * 0.09f).dp).background(
                                                Color.Transparent), contentAlignment = Alignment.Center){
                                                OutlinedButton(onClick = {
                                                    window.open("https://github.com/CSAbhiOnline","_blank")

                                                }, modifier = Modifier.width((widthofscreen * 0.09f).dp) , colors = ButtonDefaults.outlinedButtonColors(backgroundColor= Color.Transparent), border = BorderStroke(1.dp,themedTextcolor), shape = RoundedCornerShape(16.dp)){
                                                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically){
                                                        Text("See more", style =  TextStyle(
                                                            fontSize = (widthofscreen * 0.012f).sp,
                                                            fontFamily = FontFamily.Serif,
                                                            color = onBackgroundColor,
                                                            fontWeight = FontWeight.Light,
                                                            fontStyle = FontStyle.Italic
                                                        ), modifier = Modifier.weight(0.7f)

                                                        )
                                                        Icon(Icons.Default.ArrowForward, tint = themedTextcolor, contentDescription = "")
                                                    }

                                            }
                                            }
                                        }
                                        item{
                                            Spacer(modifier = Modifier.width((widthofscreen * 0.06f).dp))
                                        }

                                    }
                                    Spacer(
                                        modifier = Modifier.height((widthofscreen*0.1).dp).fillMaxWidth()
                                            .background(Color.Transparent)
                                    )
                                    Text("Fun fact! This website was also created using Kotlin!", modifier =Modifier.fillMaxWidth(),style= TextStyle(
                                        fontSize = (widthofscreen*0.02f).sp,
                                        textAlign = TextAlign.Center,
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamMedium)),
                                        fontWeight = FontWeight.Medium,
                                        fontStyle = FontStyle.Italic
                                    ),
                                    )
                                }
                            }

                        }
                    }
                    item {
                        Spacer(
                            modifier = Modifier.height(1.dp).fillMaxWidth()
                                .background(onPrimaryColor)
                        )
                    }
//contacts part
                    item{
                        FadeInItem {
                            Column(
                                Modifier.fillMaxWidth().wrapContentHeight()
                            ) {
                                var height by remember{
                                    mutableStateOf(0.dp)
                                }
                                Spacer(Modifier.fillMaxWidth().height((widthofscreen * 0.03f).dp))
                                Text(
                                    "Let's Connect!",
                                    style = TextStyle(
                                        color = onBackgroundColor,
                                        fontFamily = FontFamily(Font(Res.font.GothamBold)),
                                        fontSize = (widthofscreen * 0.03f).sp
                                    ),
                                    modifier = Modifier.padding(horizontal = (widthofscreen * 0.025f).dp, vertical = (widthofscreen * 0.02f).dp)
                                )
                                Row(
                                    Modifier.fillMaxWidth().padding(horizontal = (widthofscreen * 0.05f).dp), verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Column(Modifier.weight(1f).onGloballyPositioned {
                                       height= it.size.height.dp
                                    })
                                    {
                                        Row(
                                            Modifier.fillMaxWidth().padding(vertical = (widthofscreen * 0.015f).dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.02f).dp)
                                        ){
                                            Icon(imageVector = Icons.Default.MailOutline, contentDescription = "", modifier = Modifier.size((widthofscreen * 0.037f).dp).background(
                                                Color.Transparent), tint = onBackgroundColor)
                                            Text("ovnaba2@gmail.com", style = TextStyle(
                                                fontSize = (widthofscreen * 0.015f).sp,
                                                color = onBackgroundColor,
                                                fontFamily = FontFamily.SansSerif,
                                                textDecoration = TextDecoration.Underline
                                            ), modifier = Modifier.clickable {
                                                window.open("https://mail.google.com/mail/u/1/#inbox?compose=GTvVlcSMVxdjkMMMbtwpLMZHkCqDdxHsSbMnMnsBBKNPdkkwLXvpbbNsggqKwqzwhncPrmlPjMQjt","_blank")
                                            }
                                            )
                                        }
                                        Row(
                                            Modifier.fillMaxWidth().padding(vertical = (widthofscreen * 0.02f).dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.02f).dp)
                                        ){
                                            Icon(painter = painterResource(Res.drawable.github_mark), contentDescription = "", modifier = Modifier.size((widthofscreen * 0.037f).dp).background(
                                                Color.Transparent), tint = Color.Unspecified)
                                            Text("github.com/CSAbhiOnline", style = TextStyle(
                                                 fontSize = (widthofscreen * 0.015f).sp,
                                                color = onBackgroundColor,
                                                fontFamily = FontFamily.SansSerif,
                                                textDecoration = TextDecoration.Underline
                                            ), modifier = Modifier.clickable {
                                                window.open("https://github.com/CSAbhiOnline", "_blank")
                                            }
                                            )
                                        }
                                        Row(
                                            Modifier.fillMaxWidth().padding(vertical = (widthofscreen * 0.015f).dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.02f).dp)
                                        ){
                                            Icon(painter = painterResource(Res.drawable.redditlogo2436), contentDescription = "", modifier = Modifier.size((widthofscreen * 0.037f).dp).background(
                                                Color.Transparent), tint = Color.Unspecified)
                                            Text("u/CSAbhiOnline", style = TextStyle(
                                                fontSize = (widthofscreen * 0.015f).sp,
                                                color = onBackgroundColor,
                                                fontFamily = FontFamily.SansSerif,
                                                textDecoration = TextDecoration.Underline
                                            ), modifier = Modifier.clickable {
                                                window.open("https://www.reddit.com/user/CSAbhiOnline/", "_blank")
                                            }
                                            )
                                        }
                                        Row(
                                            Modifier.fillMaxWidth().padding(vertical = (widthofscreen * 0.015f).dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.02f).dp)
                                        ){
                                            Icon(painter = painterResource(Res.drawable.instagralogo), contentDescription = "", modifier = Modifier.size((widthofscreen * 0.037f).dp).background(
                                                Color.Transparent), tint = Color.Unspecified)
                                            Text("instagram.com/_csabhi_", style = TextStyle(
                                                fontSize = (widthofscreen * 0.015f).sp,
                                                color = onBackgroundColor,
                                                fontFamily = FontFamily.SansSerif,
                                                textDecoration = TextDecoration.Underline
                                            ), modifier = Modifier.clickable {
                                                window.open("https://www.instagram.com/_csabhi_/", "_blank")
                                            }
                                            )
                                        }
                                        Row(
                                            Modifier.fillMaxWidth().padding(vertical = (widthofscreen * 0.015f).dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy((widthofscreen * 0.02f).dp)
                                        ){
                                            Icon(painter = painterResource(Res.drawable.facebooklogo), contentDescription = "", modifier = Modifier.size((widthofscreen * 0.037f).dp).background(
                                                Color.Transparent), tint = Color.Unspecified)
                                            Text("facebook.com/Abhinaba Kundu", style = TextStyle(
                                                fontSize = (widthofscreen * 0.015f).sp,
                                                color = onBackgroundColor,
                                                fontFamily = FontFamily.SansSerif,
                                                textDecoration = TextDecoration.Underline
                                            ), modifier = Modifier.clickable {
                                                window.open("https://www.facebook.com/abhinaba.kundu.3/", "_blank")
                                            }
                                            )
                                        }


                                    }
                                    Column(
                                        Modifier.weight(1f)
                                    ) {Box(
                                        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.CenterEnd
                                    ){
                                        Icon(painter = painterResource(Res.drawable.whatsappfinalqr), contentDescription = "", tint = Color.Unspecified, modifier = Modifier.height(/*(widthofscreen * 0.2f).dp)*/height))
                                    }

                                    }
                                }

                            }
                        }

                    }



                }


            }


            Column(
                Modifier.wrapContentSize().align(Alignment.CenterEnd)
            ) {
                Icon(painter = painterResource(Res.drawable.facebooklogo),
                    "",
                    modifier = Modifier.size((widthofscreen * 0.04f).dp)
                        .padding((widthofscreen * 0.01f).dp).background(
                        Color.Transparent
                    ).clickable {
                        window.open("https://www.facebook.com/abhinaba.kundu.3/", "_blank")
                    },
                    tint = Color.Unspecified
                )

                Icon(painter = painterResource(Res.drawable.instagralogo),
                    "",
                    modifier = Modifier.size((widthofscreen * 0.04f).dp)
                        .padding((widthofscreen * 0.01f).dp).background(
                        Color.Transparent
                    ).clickable {
                        window.open("https://www.instagram.com/_csabhi_/", "_blank")
                    },
                    tint = Color.Unspecified
                )
                Icon(painter = painterResource(Res.drawable.github_mark),
                    "",
                    modifier = Modifier.size((widthofscreen * 0.04f).dp)
                        .padding((widthofscreen * 0.01f).dp).background(
                        Color.Transparent
                    ).clickable {
                        window.open("https://github.com/CSAbhiOnline", "_blank")
                    },
                    tint = Color.Unspecified
                )
                Icon(painter = painterResource(Res.drawable.redditlogo2436),
                    "",
                    modifier = Modifier.size((widthofscreen * 0.04f).dp)
                        .padding((widthofscreen * 0.01f).dp).background(
                        Color.Transparent
                    ).clickable {
                        window.open("https://www.reddit.com/user/CSAbhiOnline/", "_blank")
                    },
                    tint = Color.Unspecified
                )
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(scrollstatelazycolumn)
            )


        }
    }

}


data class techskillsitem(val name: String, val image: DrawableResource)

@Composable
fun FadeInItem(item: @Composable BoxScope.() -> Unit) {
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
