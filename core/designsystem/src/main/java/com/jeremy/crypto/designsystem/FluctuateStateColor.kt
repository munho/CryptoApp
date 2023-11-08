package com.jeremy.crypto.designsystem

import androidx.compose.ui.graphics.Color

fun Float.getFluctuateColor() =
    if (this > 0f) RiseColor
    else if (this < 0f) FallColor
    else EvenColor

val RiseColor = Color(0xFFF44141)
val FallColor = Color(0xFF0975F3)
val EvenColor = Color(0xFF40444E)