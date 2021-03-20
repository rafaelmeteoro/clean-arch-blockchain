package com.meteoro.cleanarchblockchain.charts.domain.di

import com.meteoro.cleanarchblockchain.charts.domain.repository.ChartsRepository
import com.meteoro.cleanarchblockchain.charts.domain.usecase.GetChartsUseCase
import dagger.Module
import dagger.Provides

@Module
class ChartsUseCaseModule {

    @Provides
    fun bindsGetChartsUseCase(chartsRepository: ChartsRepository): GetChartsUseCase {
        return GetChartsUseCase(chartsRepository)
    }
}
