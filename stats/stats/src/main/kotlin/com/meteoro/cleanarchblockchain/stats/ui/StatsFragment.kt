package com.meteoro.cleanarchblockchain.stats.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meteoro.cleanarchblockchain.stats.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {

    private lateinit var binding: FragmentStatsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
