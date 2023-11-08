package com.jeremy.crypto.common

fun String.splitMarketCurrency(): String {
    return kotlin.runCatching { split("-")[1] }.getOrDefault("")
}

fun List<String>.mapToMarketCodesRequest(): String {
    val builder = StringBuilder()
    forEachIndexed { index, s ->
        if (index == 0) builder.append(s) else builder.append(",$s")
    }
    return builder.toString()
}