package com.jeremy.crypto.common

sealed class MarketChangeState {
    object Rise: MarketChangeState()
    object Fall: MarketChangeState()
    object Even: MarketChangeState()
}