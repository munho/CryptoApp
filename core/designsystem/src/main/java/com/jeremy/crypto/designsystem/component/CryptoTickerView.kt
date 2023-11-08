package com.jeremy.crypto.designsystem.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.jeremy.crypto.designsystem.getFluctuateColor
import com.jeremy.crypto.designsystem.toDp
import com.jeremy.crypto.model.BigDecimalMapper.formattedFluctuateString
import com.jeremy.crypto.model.BigDecimalMapper.formattedString
import com.jeremy.crypto.model.BigDecimalMapper.newBigDecimal

@Composable
fun CryptoTickerView(
    modifier: Modifier = Modifier,
    name: String,
    lastPrice: String,
    fluctuateRate: Float,
    fluctuatePrice: Float,
    onClickEvent: () -> Unit
) = Row(
    modifier = modifier
        .clickable { onClickEvent.invoke() }
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 8.dp),
    verticalAlignment = Alignment.Top
) {
    Text(
        text = name,
        modifier = Modifier,
        textAlign = TextAlign.Center,
        fontSize = 18.toDp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.width(10.dp))
    Text(
        text = lastPrice,
        modifier = Modifier.weight(1f),
        textAlign = TextAlign.End,
        fontSize = 16.toDp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.width(10.dp))
    Column(
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .widthIn(min = 60.dp)
            .fillMaxHeight()
    ) {
        FluctuationStatusView(
            fluctuateRate = fluctuateRate,
            fontSize = 14.toDp
        )
        Text(
            modifier = Modifier.padding(end = 10.dp),
            text = fluctuatePrice.newBigDecimal(scale = 2).formattedString(),
            textAlign = TextAlign.End,
            fontSize = 12.toDp,
            fontWeight = FontWeight.Bold,
            color = fluctuatePrice.getFluctuateColor()
        )
    }
}

@Composable
fun FluctuationStatusView(
    modifier: Modifier = Modifier,
    fluctuateRate: Float,
    fontSize: TextUnit = 16.toDp,
    radius: Dp = 8.dp,
) = Surface(
    color = fluctuateRate.getFluctuateColor(),
    modifier = modifier,
    shape = RoundedCornerShape(radius)
) {
    Text(
        text = fluctuateRate.formattedFluctuateString() + "%",
        fontSize = fontSize,
        color = Color.White,
        modifier = Modifier.padding(horizontal = 10.dp)
    )
}