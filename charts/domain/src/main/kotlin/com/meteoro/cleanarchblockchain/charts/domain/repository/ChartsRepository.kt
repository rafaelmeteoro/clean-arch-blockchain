package com.meteoro.cleanarchblockchain.charts.domain.repository

import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsDomain
import kotlinx.coroutines.flow.Flow

interface ChartsRepository {
    fun getCharts(timespan: String, rollingAverage: String): Flow<ChartsDomain>
}
