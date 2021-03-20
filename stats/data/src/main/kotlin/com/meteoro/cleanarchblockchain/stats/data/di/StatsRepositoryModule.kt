package com.meteoro.cleanarchblockchain.stats.data.di

import com.meteoro.cleanarchblockchain.stats.data.repository.StatsRepositoryImpl
import com.meteoro.cleanarchblockchain.stats.domain.repository.StatsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class StatsRepositoryModule {

    @Binds
    abstract fun bindsStatsRepository(statsRepositoryImpl: StatsRepositoryImpl): StatsRepository
}
