package com.meteoro.cleanarchblockchain.stats.domain.usecase

import com.meteoro.cleanarchblockchain.stats.domain.model.StatsDomain
import com.meteoro.cleanarchblockchain.stats.domain.repository.StatsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetStatsUseCase @Inject constructor(
    private val statsRepository: StatsRepository
) {
    fun execute(): Flow<StatsDomain> {
        return statsRepository.getStats()
    }
}
