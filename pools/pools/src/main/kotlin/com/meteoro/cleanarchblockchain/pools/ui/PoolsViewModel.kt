package com.meteoro.cleanarchblockchain.pools.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meteoro.cleanarchblockchain.pools.domain.usecase.GetPoolUseCase
import com.meteoro.cleanarchblockchain.pools.model.Pools
import com.meteoro.cleanarchblockchain.pools.model.PoolsPeriod
import com.meteoro.cleanarchblockchain.pools.model.toUi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class PoolsViewModel @Inject constructor(
    private val getPoolsUseCase: GetPoolUseCase
) : ViewModel() {

    sealed class ViewState {
        object Error : ViewState()
        object Loading : ViewState()
        data class Success(val pools: Pools) : ViewState()
    }

    private val _viewState = MutableLiveData<ViewState>()
    val viewState: LiveData<ViewState> = _viewState

    fun retrievePools(poolsPeriod: PoolsPeriod) {
        getPoolsUseCase
            .execute(poolsPeriod.toDomain())
            .onStart { _viewState.postValue(ViewState.Loading) }
            .onEach { _viewState.postValue(ViewState.Success(it.toUi())) }
            .catch { _viewState.postValue(ViewState.Error) }
            .launchIn(viewModelScope)
    }
}
