package com.cowday.pennywise.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cowday.pennywise.R

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_thin, FontWeight.Thin),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_extra_bold, FontWeight.ExtraBold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 34.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
    titleMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    titleSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    bodySmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    labelLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Light
    ),
    labelMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 12.sp,
        fontWeight = FontWeight.Light
    ),
    labelSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 10.sp,
        fontWeight = FontWeight.Light
    )
)