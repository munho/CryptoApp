package com.jeremy.crypto.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremy.crypto.domain.usecase.GetMarketCodeUseCase
import com.jeremy.crypto.domain.usecase.SetMarketCodeCacheUseCase
import com.jeremy.crypto.model.MarketCodeResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMarketCodeUseCase: GetMarketCodeUseCase,
    private val setMarketCodeCacheUseCase: SetMarketCodeCacheUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<MainViewState>(MainViewState())
    val viewState: StateFlow<MainViewState> get() = _viewState

    init {
        fetchMarketCode()
    }

    private fun fetchMarketCode() = viewModelScope.launch {
        getMarketCodeUseCase.execute()
            .onSuccess {
                setMarketCodeCache(it)
                _viewState.update { it.copy(fetchSuccess = true) }
            }
            .onFailure {
                _viewState.update { it.copy(fetchError = true) }
            }
    }

    private fun setMarketCodeCache(codeList: List<MarketCodeResponseItem>) = viewModelScope.launch {
        setMarketCodeCacheUseCase.execute(
            krwCodes = codeList.filter { it.market.contains(KRW_SYMBOL_PREFIX) }.map { it.market }
                .toList(),
            btcCodes = codeList.filter { it.market.contains(BTC_SYMBOL_PREFIX) }.map { it.market }
                .toList(),
        )
    }

    companion object {
        private const val KRW_SYMBOL_PREFIX = "KRW-"
        private const val BTC_SYMBOL_PREFIX = "BTC-"
    }
}