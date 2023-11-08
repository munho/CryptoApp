package com.jeremy.crypto.designsystem

import androidx.compose.ui.graphics.Color

fun Float.getFluctuateColor() =
    if (this > 0f) Color(0xFFF44141)
    else if (this < 0f) Color(0xFF0975F3)
    else Color(0xFF40444E)