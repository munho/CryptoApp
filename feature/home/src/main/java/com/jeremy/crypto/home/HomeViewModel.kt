package com.jeremy.crypto.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremy.crypto.common.mapToMarketCodesRequest
import com.jeremy.crypto.domain.usecase.GetMarketCodeCacheUseCase
import com.jeremy.crypto.domain.usecase.GetMarketsTickerUseCase
import com.jeremy.crypto.model.CurrencyCache
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getMarketCodeCacheUseCase: GetMarketCodeCacheUseCase,
    private val getMarketsTickerUseCase: GetMarketsTickerUseCase
) : ViewModel() {

    val uiState: StateFlow<HomeViewState> = getMarketCodeCacheUseCase()
        .onStart { HomeViewState.Loading }
        .map(::getMarketsTicker)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeViewState.Wait
        )

    private suspend fun getMarketsTicker(currencyCache: CurrencyCache): HomeViewState {
        return runCatching {
            getMarketsTickerUseCase(markets = currencyCache.krwMarketCodes.mapToMarketCodesRequest())
        }.fold(
            onSuccess = {
                HomeViewState.Success(it)
            },
            onFailure = {
                HomeViewState.Error(it.message)
            }
        )
    }
}