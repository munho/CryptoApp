package com.jeremy.crypto.common

fun String.splitMarketCurrency(): String {
    return kotlin.runCatching { split("-")[1] }.getOrDefault("")
}

fun List<String>.mapToMarketCodesRequest(): String {
    return StringBuilder().apply {
        forEachIndexed { index, s ->
            if (index == 0) append(s) else append(",$s")
        }
    }.toString()
}