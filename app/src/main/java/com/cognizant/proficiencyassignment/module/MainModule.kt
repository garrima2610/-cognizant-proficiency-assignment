package com.cognizant.proficiencyassignment.module

import com.cognizant.proficiencyassignment.helper.Constants
import com.cognizant.proficiencyassignment.network.NetworkApi
import com.cognizant.proficiencyassignment.repository.DataRepository
import com.cognizant.proficiencyassignment.viewmodel.CountryViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val mainModule = module {

    single { DataRepository(get()) }

    single { createWebService() }

    viewModel { CountryViewModel(get()) }

}

/**
 * Creating Retrofit client for retrieving data from server
 */
fun createWebService(): NetworkApi {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()

    return retrofit.create(NetworkApi::class.java)
}