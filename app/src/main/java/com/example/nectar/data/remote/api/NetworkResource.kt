package com.example.nectar.data.remote.api

import com.example.nectar.base.BaseException

open class NetworkResource<T>(
    val status: NetworkState,
    val data: T? = null,
    val error: BaseException? = null
) {
    class Loading<T>() : NetworkResource<Boolean>(NetworkState.LOADING)
    class Success<T>( data: T) : NetworkResource<T>(NetworkState.SUCCESS, data)
    class Failure<T>( error: BaseException) :
        NetworkResource<BaseException>(NetworkState.FAILED, error )


}