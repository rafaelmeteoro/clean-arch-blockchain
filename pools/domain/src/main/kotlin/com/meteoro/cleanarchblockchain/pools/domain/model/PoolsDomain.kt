package com.meteoro.cleanarchblockchain.pools.domain.model

data class PoolsDomain(
    val miningPools: List<MiningPoolDomain>
)

data class MiningPoolDomain(
    val name: String,
    val distribution: Int
)
