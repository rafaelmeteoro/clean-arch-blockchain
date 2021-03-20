package com.meteoro.cleanarchblockchain.pools.di

import android.content.Context
import com.meteoro.cleanarchblockchain.di.DaggerDependencies
import com.meteoro.cleanarchblockchain.pools.data.di.PoolsApiModule
import com.meteoro.cleanarchblockchain.pools.data.di.PoolsRepositoryModule
import com.meteoro.cleanarchblockchain.pools.domain.di.PoolsUseCaseModule
import com.meteoro.cleanarchblockchain.pools.ui.PoolsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [DaggerDependencies::class],
    modules = [
        PoolsApiModule::class,
        PoolsRepositoryModule::class,
        PoolsUseCaseModule::class,
        PoolsFeatureModule::class
    ]
)
interface PoolsComponent {

    fun inject(poolsFragment: PoolsFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun addDependencies(daggerDependencies: DaggerDependencies): Builder
        fun build(): PoolsComponent
    }
}
