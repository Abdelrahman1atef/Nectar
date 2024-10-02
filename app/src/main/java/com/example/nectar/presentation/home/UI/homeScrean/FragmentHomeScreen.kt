package com.example.nectar.presentation.home.UI.homeScrean

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieproject.presentation.home.page_home.HomeViewModel
import com.example.nectar.base.BaseException
import com.example.nectar.base.ViewState
import com.example.nectar.data.model.DataResponse
import com.example.nectar.databinding.FragmentHomeScreenBinding
import com.example.nectar.presentation.home.adapter.BestSellingAdapter
import com.example.nectar.presentation.home.adapter.ExclusiveOfferAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHomeScreen : Fragment() {
    private lateinit var binding: FragmentHomeScreenBinding
    private lateinit var exclusiveOfferAdapter: ExclusiveOfferAdapter
    private lateinit var bestSellingAdapter: BestSellingAdapter
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        observeViewModel()
    }

    private fun initView() {
        getViewModel()
        setupRv()
    }

    private fun getViewModel() {
        viewModel.getGroceriesData()
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            viewModel.groceriesDataStatus.collect {

                when (it) {
                    is ViewState.Loaded -> {
                        val data = it.data as? List<DataResponse> // Cast to List<DataDetails>
                        if (data != null) {
                            onSuccess(data)
                        } else {
                            // Handle case where data is not a List<DataDetails>
                            Log.e("myTest", "observeViewModel: Unexpected data type", )
                        }
                    }
                    is ViewState.Error -> onError(it.error!!)
                    else -> {
                        Log.e("myTest", "observeViewModel: Empty State", )
                    }
                }
            }
        }
    }
    private fun onError(error: BaseException) {
        Toast.makeText(requireContext(), error.statusMessage, Toast.LENGTH_SHORT).show()
    }

    private fun onSuccess(data: List<DataResponse>) {
        if (::exclusiveOfferAdapter.isInitialized) {
            exclusiveOfferAdapter.setData(data)
            bestSellingAdapter.setData(data)
        }
    }
    private fun setupRv() {
        setupViewPagerAndTabLayout(
            viewPager = binding.viewPager.viewPager,  // Adjust ID as necessary
            tabLayout = binding.viewPager.tabLayout,  // Adjust ID as necessary
            context = requireContext()
        )
        setupExclusiveOfferRv()
        setupBestSellingRv()
    }

    private fun setupBestSellingRv() {
        bestSellingAdapter = BestSellingAdapter()
        binding.bestSelling.rvBestSelling.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.bestSelling.rvBestSelling.adapter = exclusiveOfferAdapter
    }

    private fun setupExclusiveOfferRv() {
        exclusiveOfferAdapter = ExclusiveOfferAdapter()
        binding.exclusiveOffer.rvExclusiveOffer.layoutManager= LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.exclusiveOffer.rvExclusiveOffer.adapter = exclusiveOfferAdapter
    }

}








































