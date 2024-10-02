package com.example.movieproject.presentation.home.page_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nectar.base.ViewState
import com.example.nectar.data.model.DataResponse
import com.example.nectar.data.remote.api.NetworkState
import com.example.nectar.domain.usecase.GetGroceriesDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getGroceriesDataUseCase: GetGroceriesDataUseCase,
): ViewModel() {

    private val _groceriesDataStatus=
        MutableStateFlow<ViewState<List<DataResponse>>>(ViewState.Empty())
    val groceriesDataStatus: StateFlow<ViewState<List<DataResponse>>> = _groceriesDataStatus

        fun getGroceriesData() {
            viewModelScope.launch {
                getGroceriesDataUseCase.getGroceriesData().collect{
                    val state : ViewState<List<DataResponse>> =when (it.status) {
                        NetworkState.SUCCESS -> ViewState.Loaded(it.data!!)
                        NetworkState.FAILED -> ViewState.Error(it.error)
                        else -> ViewState.Empty()
                    }
                    _groceriesDataStatus.value=state
                }
            }
        }
    }