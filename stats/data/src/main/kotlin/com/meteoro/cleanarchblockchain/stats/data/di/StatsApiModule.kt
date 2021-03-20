package com.meteoro.cleanarchblockchain.stats.data.di

import com.meteoro.cleanarchblockchain.stats.data.api.BlockChainStatsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class StatsApiModule {

    @Provides
    fun provideBlockChainStatsApi(retrofit: Retrofit): BlockChainStatsApi {
        return retrofit.create(BlockChainStatsApi::class.java)
    }
}
