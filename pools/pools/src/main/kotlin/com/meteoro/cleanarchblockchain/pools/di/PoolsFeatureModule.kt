package com.meteoro.cleanarchblockchain.pools.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meteoro.cleanarchblockchain.di.ViewModelFactory
import com.meteoro.cleanarchblockchain.di.ViewModelKey
import com.meteoro.cleanarchblockchain.pools.ui.PoolsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PoolsFeatureModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PoolsViewModel::class)
    internal abstract fun poolsViewModel(viewModel: PoolsViewModel): ViewModel
}
