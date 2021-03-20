package com.meteoro.cleanarchblockchain.pools.domain.usecase

import com.meteoro.cleanarchblockchain.pools.domain.model.PoolsDomain
import com.meteoro.cleanarchblockchain.pools.domain.model.PoolsPeriodDomain
import com.meteoro.cleanarchblockchain.pools.domain.repository.PoolsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPoolUseCase @Inject constructor(
    private val poolsRepository: PoolsRepository
) {
    fun execute(poolsPeriodDomain: PoolsPeriodDomain): Flow<PoolsDomain> {
        return poolsRepository.getPools(poolsPeriodDomain.value)
    }
}
