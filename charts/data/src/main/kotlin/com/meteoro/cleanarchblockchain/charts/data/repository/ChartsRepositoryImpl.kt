package com.meteoro.cleanarchblockchain.charts.data.repository

import com.meteoro.cleanarchblockchain.charts.data.api.BlockchainChartsApi
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsDomain
import com.meteoro.cleanarchblockchain.charts.domain.repository.ChartsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChartsRepositoryImpl @Inject constructor(
    private val blockchainChartsApi: BlockchainChartsApi
) : ChartsRepository {

    override fun getCharts(timespan: String, rollingAverage: String): Flow<ChartsDomain> {
        return flow {
            val result = blockchainChartsApi.getCharts(timespan, rollingAverage).toDomain()
            emit(result)
        }
    }
}
