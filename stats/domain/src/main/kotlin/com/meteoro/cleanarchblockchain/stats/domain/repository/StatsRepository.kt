package com.meteoro.cleanarchblockchain.stats.domain.repository

import com.meteoro.cleanarchblockchain.stats.domain.model.StatsDomain
import kotlinx.coroutines.flow.Flow

interface StatsRepository {
    fun getStats(): Flow<StatsDomain>
}
