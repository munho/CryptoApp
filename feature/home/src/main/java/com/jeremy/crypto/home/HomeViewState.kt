package com.jeremy.crypto.home

import com.jeremy.crypto.model.CurrencyUiItem

sealed class HomeViewState {
    object Wait : HomeViewState()

    object Loading : HomeViewState()

    data class Success(
        val krwMarketList: List<CurrencyUiItem>,
        val event: HomeViewEvent = HomeViewEvent.Nothing
    ) : HomeViewState()

    data class Error(
        val message: String? = null
    ) : HomeViewState()
}

sealed class HomeViewEvent {
    object Nothing: HomeViewEvent()
}
