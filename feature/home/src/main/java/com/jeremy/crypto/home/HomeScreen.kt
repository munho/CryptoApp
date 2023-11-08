package com.jeremy.crypto.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jeremy.crypto.designsystem.component.CryptoTickerView
import com.jeremy.crypto.designsystem.splitMarketCurrency
import com.jeremy.crypto.model.BigDecimalMapper.formattedString
import com.jeremy.crypto.model.CurrencyUiItem
import com.jeremy.crypto.navigation.AppComposeNavigator
import com.jeremy.crypto.navigation.route.MainRoute

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
                        CryptoTickerView(
                            name = it.market.splitMarketCurrency(),
                            lastPrice = it.tradePrice.formattedString(),
                            fluctuateRate = it.signedChangeRate.toFloat(),
                            fluctuatePrice = it.signedChangePrice.toFloat(),
                            onClickEvent = { onClick.invoke(it) }
                        )
                    }
                }
            }

            is HomeViewState.Error -> {

            }

        }
    }
}