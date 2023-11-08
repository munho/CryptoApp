package com.jeremy.crypto.designsystem

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

val Int.toDp: TextUnit
    @Composable
    get() = with(LocalDensity.current) { this@toDp.dp.toSp() }

val Float.toDp: TextUnit
    @Composable
    get() = with(LocalDensity.current) { this@toDp.dp.toSp() }

fun String.splitMarketCurrency(): String {
    return kotlin.runCatching { split("-")[1] }.getOrDefault("")
}