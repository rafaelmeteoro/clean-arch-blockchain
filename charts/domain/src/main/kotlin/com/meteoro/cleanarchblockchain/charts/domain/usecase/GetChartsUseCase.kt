package com.meteoro.cleanarchblockchain.charts.domain.usecase

import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsDomain
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsPeriodDomain
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsRollingAverageDomain
import com.meteoro.cleanarchblockchain.charts.domain.repository.ChartsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetChartsUseCase @Inject constructor(
    private val chartsRepository: ChartsRepository
) {
    fun execute(
        chartsPeriodDomain: ChartsPeriodDomain,
        chartsRollingAverageDomain: ChartsRollingAverageDomain = ChartsRollingAverageDomain.TWENTY_FOUR_HOURS
    ): Flow<ChartsDomain> {
        return chartsRepository.getCharts(chartsPeriodDomain.value, chartsRollingAverageDomain.value)
    }
}
