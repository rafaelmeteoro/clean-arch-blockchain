package com.meteoro.cleanarchblockchain.pools.domain.repository

import com.meteoro.cleanarchblockchain.pools.domain.model.PoolsDomain
import kotlinx.coroutines.flow.Flow

interface PoolsRepository {
    fun getPools(timespan: String): Flow<PoolsDomain>
}
