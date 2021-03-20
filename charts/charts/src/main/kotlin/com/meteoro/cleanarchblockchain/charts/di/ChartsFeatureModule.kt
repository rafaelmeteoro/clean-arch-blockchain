package com.meteoro.cleanarchblockchain.charts.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meteoro.cleanarchblockchain.charts.ui.ChartsViewModel
import com.meteoro.cleanarchblockchain.di.ViewModelFactory
import com.meteoro.cleanarchblockchain.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ChartsFeatureModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ChartsViewModel::class)
    internal abstract fun chartsViewModel(viewModel: ChartsViewModel): ViewModel
}
