package com.jeremy.crypto.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeremy.crypto.domain.usecase.GetMarketCodeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMarketCodeUseCase: GetMarketCodeUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow<MainViewState>(MainViewState())
    val viewState: StateFlow<MainViewState> get() = _viewState

    init {
        fetchMarketCode()
    }

    private fun fetchMarketCode() = viewModelScope.launch {
        getMarketCodeUseCase.execute()
            .onSuccess {
                _viewState.update {
                    it.copy(successLoad = true)
                }
            }
            .onFailure {
                // throw global error
            }
    }

}