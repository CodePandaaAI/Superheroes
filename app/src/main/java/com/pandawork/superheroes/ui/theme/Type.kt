package com.pandawork.superheroes.ui.theme

import com.pandawork.superheroes.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val BungeeSpice = FontFamily(
    Font(R.font.bungee_spice_regular)
)

val RobotoMono = FontFamily(
    Font(R.font.roboto_mono_regular)
)

val WinkyRough = FontFamily(
    Font(R.font.winky_rough_regular)
)

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = BungeeSpice,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp
    ),
    titleLarge = TextStyle(
        fontFamily = WinkyRough,
        fontSize = 20.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = RobotoMono,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
)