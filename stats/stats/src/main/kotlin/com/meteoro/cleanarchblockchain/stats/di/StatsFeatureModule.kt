package com.meteoro.cleanarchblockchain.stats.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meteoro.cleanarchblockchain.di.ViewModelFactory
import com.meteoro.cleanarchblockchain.di.ViewModelKey
import com.meteoro.cleanarchblockchain.stats.ui.StatsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class StatsFeatureModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StatsViewModel::class)
    internal abstract fun statsViewModel(viewModel: StatsViewModel): ViewModel
}
