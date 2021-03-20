package com.meteoro.cleanarchblockchain.stats.data.api

import com.meteoro.cleanarchblockchain.stats.data.model.StatsEntity
import retrofit2.http.GET

interface BlockChainStatsApi {
    @GET("stats")
    suspend fun getStats(): StatsEntity
}
