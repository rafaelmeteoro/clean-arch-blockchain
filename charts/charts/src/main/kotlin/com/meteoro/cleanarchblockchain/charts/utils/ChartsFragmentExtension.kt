package com.meteoro.cleanarchblockchain.charts.utils

import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.meteoro.cleanarchblockchain.charts.R
import com.meteoro.cleanarchblockchain.charts.di.DaggerChartsComponent
import com.meteoro.cleanarchblockchain.charts.ui.ChartsFragment
import com.meteoro.cleanarchblockchain.di.DaggerDependencies
import dagger.hilt.android.EntryPointAccessors

internal fun ChartsFragment.inject() {
    DaggerChartsComponent
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
internal fun ChartsFragment.getGraphDataSetColor(): Int {
    return ContextCompat.getColor(requireContext(), R.color.chart_line_color)
}

@ColorInt
internal fun ChartsFragment.getGraphDataHightlightColor(): Int {
    return ContextCompat.getColor(requireContext(), R.color.chart_line_highlight_color)
}
