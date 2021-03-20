package com.meteoro.cleanarchblockchain.stats.utils

import com.meteoro.cleanarchblockchain.di.DaggerDependencies
import com.meteoro.cleanarchblockchain.stats.di.DaggerStatsComponent
import com.meteoro.cleanarchblockchain.stats.ui.StatsFragment
import dagger.hilt.android.EntryPointAccessors

internal fun StatsFragment.inject() {
    DaggerStatsComponent
        .builder()
        .context(requireContext())
        .appDependencies(
            EntryPointAccessors.fromApplication(
                requireContext(),
                DaggerDependencies::class.java
            )
        )
        .build()
        .inject(this)
}
