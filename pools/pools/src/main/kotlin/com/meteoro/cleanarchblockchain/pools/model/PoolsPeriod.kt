package com.meteoro.cleanarchblockchain.pools.model

import androidx.annotation.StringRes
import com.meteoro.cleanarchblockchain.pools.R
import com.meteoro.cleanarchblockchain.pools.domain.model.PoolsPeriodDomain

enum class PoolsPeriod(@StringRes val value: Int) {
    TWENTY_FOUR_HOURS(R.string.period_twenty_four_hours),
    FORTY_EIGHT_HOURS(R.string.period_forty_eight_hours),
    FOUR_DAYS(R.string.period_four_days);

    fun toDomain(): PoolsPeriodDomain {
        return PoolsPeriodDomain.values().firstOrNull { it.name == name } ?: PoolsPeriodDomain.TWENTY_FOUR_HOURS
    }
}
