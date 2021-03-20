package com.meteoro.cleanarchblockchain.stats.di

import android.content.Context
import com.meteoro.cleanarchblockchain.di.DaggerDependencies
import com.meteoro.cleanarchblockchain.stats.data.di.StatsApiModule
import com.meteoro.cleanarchblockchain.stats.data.di.StatsRepositoryModule
import com.meteoro.cleanarchblockchain.stats.domain.di.StatsUseCaseModule
import com.meteoro.cleanarchblockchain.stats.ui.StatsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [DaggerDependencies::class],
    modules = [
        StatsApiModule::class,
        StatsRepositoryModule::class,
        StatsUseCaseModule::class,
        StatsFeatureModule::class
    ]
)
interface StatsComponent {

    fun inject(statsFragment: StatsFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(daggerDependencies: DaggerDependencies): Builder
        fun build(): StatsComponent
    }
}
