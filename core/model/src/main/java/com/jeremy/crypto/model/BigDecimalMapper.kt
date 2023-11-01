package com.jeremy.crypto.model

import java.math.BigDecimal
import java.math.RoundingMode
import java.text.DecimalFormat

object BigDecimalMapper {
    private val format: DecimalFormat = DecimalFormat("###,###")
    fun Double.newBigDecimal(
        scale: Int = 0,
        roundingMode: RoundingMode = RoundingMode.FLOOR
    ): BigDecimal {
        return BigDecimal(this).setScale(scale, roundingMode)
    }

    fun BigDecimal.formattedString(): String {
        return format.format(this)
    }
}