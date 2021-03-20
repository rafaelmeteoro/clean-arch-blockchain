package com.meteoro.cleanarchblockchain.pools.utils

import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.meteoro.cleanarchblockchain.di.DaggerDependencies
import com.meteoro.cleanarchblockchain.pools.R
import com.meteoro.cleanarchblockchain.pools.di.DaggerPoolsComponent
import com.meteoro.cleanarchblockchain.pools.ui.PoolsFragment
import dagger.hilt.android.EntryPointAccessors

internal fun PoolsFragment.inject() {
    DaggerPoolsComponent
        .builder()
        .context(requireContext())
        .addDependencies(
            EntryPointAccessors.fromApplication(
                requireContext(),
                DaggerDependencies::class.java
            )
        )
        .build()
        .inject(this)
}

@ColorInt
internal fun PoolsFragment.getGraphDataColors(): List<Int> {
    return listOf(
        ContextCompat.getColor(requireContext(), R.color.chart_pie_first_color),
        ContextCompat.getColor(requireContext(), R.color.chart_pie_second_color),
        ContextCompat.getColor(requireContext(), R.color.chart_pie_third_color),
        ContextCompat.getColor(requireContext(), R.color.chart_pie_fourth_color),
        ContextCompat.getColor(requireContext(), R.color.chart_pie_fifth_color)
    )
}

@ColorInt
internal fun PoolsFragment.getGraphLabelColor(): Int {
    return ContextCompat.getColor(requireContext(), R.color.chart_pie_label_color)
}

internal fun PoolsFragment.getGraphSliceSpace(): Float {
    return resources.getDimensionPixelSize(com.meteoro.cleanarchblockchain.R.dimen.spacing_xsmall).toFloat()
}

internal fun PoolsFragment.getGraphTransparentCircleRadius(): Float {
    return resources.getDimensionPixelSize(com.meteoro.cleanarchblockchain.R.dimen.spacing_large).toFloat()
}

internal fun PoolsFragment.getGraphHoleRadius(): Float {
    return resources.getDimensionPixelSize(com.meteoro.cleanarchblockchain.R.dimen.spacing_medium).toFloat()
}
