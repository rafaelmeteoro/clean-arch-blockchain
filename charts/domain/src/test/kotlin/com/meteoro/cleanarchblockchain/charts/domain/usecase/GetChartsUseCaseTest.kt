package com.meteoro.cleanarchblockchain.charts.domain.usecase

import com.google.common.truth.Truth
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsDomain
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsPeriodDomain
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsRollingAverageDomain
import com.meteoro.cleanarchblockchain.charts.domain.model.ChartsValueDomain
import com.meteoro.cleanarchblockchain.charts.domain.repository.ChartsRepository
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.junit.jupiter.api.assertThrows

@ExperimentalCoroutinesApi
class GetChartsUseCaseTest {

    companion object {
        private const val ARGUMENT_TIME_SPAN = "7days"
        private const val ARGUMENT_ROLLING_AVERAGE = "8hours"
    }

    private val chartsRepository: ChartsRepository = mockk()
    private val getChartsUseCase: GetChartsUseCase = GetChartsUseCase(chartsRepository)

    @Test
    fun `GIVEN successful result WHEN requests charts usecase THEN return stats`() {
        val chartsDomain = ChartsDomain(
            name = "Chart name",
            unit = "Transactions",
            period = "day",
            description = "The number of daily confirmed Bitcoin transactions",
            values = listOf(
                ChartsValueDomain(
                    timestamp = 1442534400,
                    value = 188330.0f
                )
            )
        )

        every { chartsRepository.getCharts(ARGUMENT_TIME_SPAN, ARGUMENT_ROLLING_AVERAGE) } returns flowOf(chartsDomain)

        runBlockingTest {
            getChartsUseCase.execute(ChartsPeriodDomain.ONE_WEEK, ChartsRollingAverageDomain.EIGHT_HOURS)
                .collect { result ->
                    Truth.assertThat(result).isEqualTo(chartsDomain)
                }
        }
    }

    @Test
    fun `GIVEN failure result WHEN requests charts usecase THEN return with exception`() {
        every {
            chartsRepository.getCharts(
                ARGUMENT_TIME_SPAN,
                ARGUMENT_ROLLING_AVERAGE
            )
        } returns flow { throw Exception() }

        assertThrows<Exception> {
            runBlockingTest {
                getChartsUseCase.execute(ChartsPeriodDomain.ONE_WEEK, ChartsRollingAverageDomain.EIGHT_HOURS).collect()
            }
        }
    }
}
