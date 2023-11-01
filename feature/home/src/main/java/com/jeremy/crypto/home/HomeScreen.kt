package com.jeremy.crypto.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jeremy.crypto.common.MILLION
import com.jeremy.crypto.model.BigDecimalMapper.formattedString
import com.jeremy.crypto.model.CurrencyUiItem
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.navigation.route.MainRoute
import java.math.BigDecimal
import java.math.RoundingMode

@Composable
fun HomeScreen(
    appNavigator: AppComposeNavigator,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val viewState = homeViewModel.uiState.collectAsStateWithLifecycle().value
    HomeScreen(
        state = viewState,
        onClick = { appNavigator.navigate(MainRoute.Detail.route) }
    )
}

@Composable
fun HomeScreen(
    state: HomeViewState,
    onClick: (CurrencyUiItem) -> Unit
) {
    val scrollState = rememberLazyListState()
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        when (state) {
            HomeViewState.Wait -> Unit
            HomeViewState.Loading -> {
                CircularProgressIndicator()
            }

            is HomeViewState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    state = scrollState
                ) {
                    items(
                        items = state.krwMarketList,
                        key = { it.market }
                    ) {
                        Row(
                            modifier = Modifier.clickable { onClick.invoke(it) }
                        ) {
                            Text(text = it.market)
                            Spacer(modifier = Modifier.weight(1f))
                            if (it.accTradePrice >= BigDecimal.valueOf(MILLION)) {
                                val result = it.accTradePrice.divide(BigDecimal.valueOf(MILLION))
                                    .setScale(0, RoundingMode.FLOOR).formattedString()
                                Text(text = "${result}백만")
                            } else {
                                Text(text = it.accTradePrice.toString())
                            }
                        }
                    }
                }
            }

            is HomeViewState.Error -> {

            }

        }
    }
}