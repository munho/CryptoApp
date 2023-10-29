package com.jeremy.crypto.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremy.crypto.domain.usecase.GetMarketCodeCacheUseCase
import com.jeremy.crypto.domain.usecase.GetMarketsTickerUseCase
import com.jeremy.crypto.model.CurrencyCache
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getMarketCodeCacheUseCase: GetMarketCodeCacheUseCase,
    private val getMarketsTickerUseCase: GetMarketsTickerUseCase
) : ViewModel() {

    fun fetchMarketCodeCache() = getMarketCodeCacheUseCase.execute()
        .map(::getMarketsTicker)
        .launchIn(viewModelScope)

    private suspend fun getMarketsTicker(currencyCache: CurrencyCache) {
        val stringBuilder = StringBuilder()
        currencyCache.krwMarketCodes.forEachIndexed { index, s ->
            if (index == 0) {
                stringBuilder.append(s)
            } else {
                stringBuilder.append(",$s")
            }
        }
        getMarketsTickerUseCase.execute(stringBuilder.toString())
    }
}