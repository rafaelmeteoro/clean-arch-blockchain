package com.meteoro.cleanarchblockchain.charts.di

import android.content.Context
import com.meteoro.cleanarchblockchain.charts.data.di.ChartsApiModule
import com.meteoro.cleanarchblockchain.charts.data.di.ChartsRepositoryModule
import com.meteoro.cleanarchblockchain.charts.domain.di.ChartsUseCaseModule
import com.meteoro.cleanarchblockchain.charts.ui.ChartsFragment
import com.meteoro.cleanarchblockchain.di.DaggerDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [DaggerDependencies::class],
    modules = [
        ChartsApiModule::class,
        ChartsRepositoryModule::class,
        ChartsUseCaseModule::class,
        ChartsFeatureModule::class
    ]
)
interface ChartsComponent {

    fun inject(chartsFragment: ChartsFragment)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun addDependencies(daggerDependencies: DaggerDependencies): Builder
        fun build(): ChartsComponent
    }
}
