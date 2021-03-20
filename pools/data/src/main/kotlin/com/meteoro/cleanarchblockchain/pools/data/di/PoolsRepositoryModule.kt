package com.meteoro.cleanarchblockchain.pools.data.di

import com.meteoro.cleanarchblockchain.pools.data.repository.PoolsRepositoryImpl
import com.meteoro.cleanarchblockchain.pools.domain.repository.PoolsRepository
import dagger.Binds
import dagger.Module

@Module
abstract class PoolsRepositoryModule {

    @Binds
    abstract fun bindsPoolsRepository(poolsRepositoryImpl: PoolsRepositoryImpl): PoolsRepository
}
