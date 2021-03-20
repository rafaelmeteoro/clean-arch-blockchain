package com.meteoro.cleanarchblockchain.stats.data.repository

import com.meteoro.cleanarchblockchain.stats.data.api.BlockChainStatsApi
import com.meteoro.cleanarchblockchain.stats.domain.model.StatsDomain
import com.meteoro.cleanarchblockchain.stats.domain.repository.StatsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StatsRepositoryImpl @Inject constructor(
    private val blockChainStatsApi: BlockChainStatsApi
) : StatsRepository {

    override fun getStats(): Flow<StatsDomain> {
        return flow {
            val result = blockChainStatsApi.getStats().toDomain()
            emit(result)
        }
    }
}
