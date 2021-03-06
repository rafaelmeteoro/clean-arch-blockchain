package com.meteoro.cleanarchblockchain.ui.tutorial

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.meteoro.cleanarchblockchain.R
import com.meteoro.cleanarchblockchain.ui.tutorial.model.TutorialPage

class TutorialPagerAdapter(
    fragment: Fragment
) : FragmentStateAdapter(fragment) {

    companion object {
        private const val TOTAL_PAGES = 4
    }

    override fun getItemCount(): Int = TOTAL_PAGES

    override fun createFragment(position: Int): Fragment {
        val (imageRes, descriptionRes) = when (position) {
            TutorialPage.PAGE_STATS -> Pair(R.drawable.ic_stats_24, R.string.tutorial_description_stats)
            TutorialPage.PAGE_CHARTS -> Pair(R.drawable.ic_chart_24, R.string.tutorial_description_charts)
            TutorialPage.PAGE_POOLS -> Pair(R.drawable.ic_pools_24, R.string.tutorial_description_pools)
            TutorialPage.PAGE_FINAL -> Pair(R.drawable.ic_check_24, R.string.tutorial_description_final)
            else -> throw IllegalStateException()
        }

        return TutorialPageFragment.newInstance(imageRes, descriptionRes)
    }
}
