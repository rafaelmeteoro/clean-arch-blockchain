package com.meteoro.cleanarchblockchain.stats.domain.di

import com.meteoro.cleanarchblockchain.stats.domain.repository.StatsRepository
import com.meteoro.cleanarchblockchain.stats.domain.usecase.GetStatsUseCase
import dagger.Module
import dagger.Provides

@Module
class StatsUseCaseModule {

    @Provides
    fun bindsGetStatsUseCase(statsRepository: StatsRepository): GetStatsUseCase {
        return GetStatsUseCase(statsRepository)
    }
}
