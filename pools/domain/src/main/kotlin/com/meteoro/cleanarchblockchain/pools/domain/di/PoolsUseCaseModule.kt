package com.meteoro.cleanarchblockchain.pools.domain.di

import com.meteoro.cleanarchblockchain.pools.domain.repository.PoolsRepository
import com.meteoro.cleanarchblockchain.pools.domain.usecase.GetPoolUseCase
import dagger.Module
import dagger.Provides

@Module
class PoolsUseCaseModule {

    @Provides
    fun bindsGetPoolsUseCase(poolsRepository: PoolsRepository): GetPoolUseCase {
        return GetPoolUseCase(poolsRepository)
    }
}
