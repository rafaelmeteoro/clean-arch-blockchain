package com.meteoro.cleanarchblockchain.pools.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.meteoro.cleanarchblockchain.pools.databinding.FragmentPoolsBinding

class PoolsFragment : Fragment() {

    lateinit var binding: FragmentPoolsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentPoolsBinding.inflate(inflater, container, false)
        return binding.root
    }
}
