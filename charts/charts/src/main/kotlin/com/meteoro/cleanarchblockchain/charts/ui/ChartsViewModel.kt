package com.meteoro.cleanarchblockchain.charts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meteoro.cleanarchblockchain.charts.domain.usecase.GetChartsUseCase
import com.meteoro.cleanarchblockchain.charts.model.Charts
import com.meteoro.cleanarchblockchain.charts.model.ChartsPeriod
import com.meteoro.cleanarchblockchain.charts.model.toUi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class ChartsViewModel @Inject constructor(
    private val useCase: GetChartsUseCase
) : ViewModel() {

    sealed class ViewState {
        object Error : ViewState()
        object Loading : ViewState()
        data class Success(val charts: Charts) : ViewState()
    }

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    fun retrieveCharts(chartsPeriod: ChartsPeriod) {
        useCase
            .execute(chartsPeriod.toDomain())
            .onStart { _viewState.postValue(ViewState.Loading) }
            .onEach { _viewState.postValue(ViewState.Success(it.toUi())) }
            .catch { _viewState.postValue(ViewState.Error) }
            .launchIn(viewModelScope)
    }
}
