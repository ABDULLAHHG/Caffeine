package com.example.caffeine.designSystem.color

import androidx.compose.ui.graphics.Color


fun lightColorTheme(
    title: Color = Color(0xDE1F1F1F),
    body: Color = Color(0x991F1F1F),
    hint: Color = Color(0x99000000),
    greetings: Color = Color(0xFFB3B3B3),
    username: Color = Color(0xFF3B3B3B),
    surface: Color = Color(0xFFFFFFFF),
    surfaceLow: Color = Color(0xFFF5F5F5),
    surfaceBlur: Color = Color(0xFFFFEEE7),
    onPrimary: Color = Color(0xDEFFFFFF),
    onPrimaryCard: Color = Color(0x3D000000),
    brownAccent: Color = Color(0xFF7C351B),
    brownAccentDark: Color = Color(0xFF291710),
    blackAccent: Color = Color(0xFF030004),


    ) = CaffeineColor(
    text = TextColor(
        title = title,
        body = body,
        hint = hint,
        greetings = greetings,
        username = username
    ),
    surface = Surface(
        surfaceHigh = surface,
        surfaceLow = surfaceLow,
        surfaceBlur = surfaceBlur,
        onPrimary = onPrimary,
        onPrimaryCard = onPrimaryCard
    ),
    status = Status(
        brownAccent = brownAccent,
        brownAccentDark = brownAccentDark,
        blackAccent = blackAccent,
    )

)
