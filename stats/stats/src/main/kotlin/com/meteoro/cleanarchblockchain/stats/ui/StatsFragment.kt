package com.meteoro.cleanarchblockchain.stats.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.meteoro.cleanarchblockchain.stats.R
import com.meteoro.cleanarchblockchain.stats.Stats
import com.meteoro.cleanarchblockchain.stats.databinding.FragmentStatsBinding
import com.meteoro.cleanarchblockchain.stats.utils.inject
import javax.inject.Inject

class StatsFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: StatsViewModel by lazy {
        ViewModelProvider(this, viewModelFactory).get(StatsViewModel::class.java)
    }

    private lateinit var binding: FragmentStatsBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        inject()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentStatsBinding.inflate(inflater, container, false)
        setupViews()
        setupObservers()
        return binding.root
    }

    private fun setupViews() {
        binding.srContent.setOnRefreshListener { viewModel.retrieveStats() }
    }

    private fun setupObservers() {
        viewModel.viewState.observe(viewLifecycleOwner, { onViewState(it) })
        viewModel.retrieveStats()
    }

    private fun onViewState(viewState: StatsViewModel.ViewState) {
        when (viewState) {
            is StatsViewModel.ViewState.Error -> onViewStateError()
            is StatsViewModel.ViewState.Loading -> onViewStateLoading()
            is StatsViewModel.ViewState.Success -> onViewStateSuccess(viewState.stats)
        }
    }

    private fun onViewStateError() {
        binding.srContent.isRefreshing = false
    }

    private fun onViewStateLoading() {
         binding.srContent.isRefreshing = true
    }

    private fun onViewStateSuccess(stats: Stats) {
        binding.apply {
            srContent.isRefreshing = false

            viewBlockSummary.tvBlocksMined.text = stats.nBlocksMined
            viewBlockSummary.tvMinutesBetweenBlocks.text = stats.minutesBetweenBlocks
            viewBlockSummary.tvBitcoinsMined.text = getString(R.string.bitcions_value, stats.totalBc)

            viewMarketSummary.tvMarketPrice.text = stats.marketPriceUsd
            viewMarketSummary.tvTradeVolumeDollar.text = stats.tradeVolumeUsd
            viewMarketSummary.tvTradeVolumeBitcoin.text = getString(R.string.bitcions_value, stats.tradeVolumeBtc)

            viewTransactionSummary.tvTotalTransactionFees.text = getString(R.string.bitcions_value, stats.totalFeesBtc)
            viewTransactionSummary.tvNumberTransactions.text = stats.nTx
            viewTransactionSummary.tvTotalOutputVolume.text = getString(R.string.bitcions_value, stats.totalBtcSent)
            viewTransactionSummary.tvEstimatedTransactionVolumeBitcoin.text = getString(R.string.bitcions_value, stats.estimatedBtcSent)
            viewTransactionSummary.tvEstimatedTransactionVolumeDollar.text = stats.estimatedTransactionVolumeUsd

            viewMiningCostSummary.tvTotalMinersRevenueDollar.text = stats.minersRevenueUsd
            viewMiningCostSummary.tvTotalMinersRevenueBitcoin.text = getString(R.string.bitcions_value, stats.minersRevenueBtc)
        }
    }
}
