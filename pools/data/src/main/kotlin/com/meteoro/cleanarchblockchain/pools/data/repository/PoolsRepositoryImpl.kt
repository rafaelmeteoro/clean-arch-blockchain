package com.meteoro.cleanarchblockchain.pools.data.repository

import com.meteoro.cleanarchblockchain.pools.data.api.BlockchainPoolsApi
import com.meteoro.cleanarchblockchain.pools.domain.model.MiningPoolDomain
import com.meteoro.cleanarchblockchain.pools.domain.model.PoolsDomain
import com.meteoro.cleanarchblockchain.pools.domain.repository.PoolsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PoolsRepositoryImpl @Inject constructor(
    private val blockchainPoolsApi: BlockchainPoolsApi
) : PoolsRepository {

    override fun getPools(timespan: String): Flow<PoolsDomain> {
        return flow {
            val result = blockchainPoolsApi.getPools(timespan)
            emit(PoolsDomain(result.map { MiningPoolDomain(it.key, it.value) }))
        }
    }
}
