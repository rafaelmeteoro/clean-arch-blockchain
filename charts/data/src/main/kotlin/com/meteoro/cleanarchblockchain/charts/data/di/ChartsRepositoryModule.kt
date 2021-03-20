package com.meteoro.cleanarchblockchain.charts.data.di

import com.meteoro.cleanarchblockchain.charts.data.repository.ChartsRepositoryImpl
import com.meteoro.cleanarchblockchain.charts.domain.repository.ChartsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class ChartsRepositoryModule {

    @Binds
    abstract fun bindsChartsRepository(chartsRepositoryImpl: ChartsRepositoryImpl): ChartsRepository
}
