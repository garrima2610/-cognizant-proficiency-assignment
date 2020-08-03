package com.cognizant.proficiencyassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cognizant.proficiencyassignment.model.BaseModel
import com.cognizant.proficiencyassignment.repository.DataRepository
import org.koin.standalone.KoinComponent

/**
 * Fetching country details from repository and passing it to View
 */
class CountryViewModel(val dataRepository: DataRepository) : ViewModel(), KoinComponent {

    var listOfProducts = MutableLiveData<BaseModel>()

    /**
     * fetching data from repository containing API call which
     * fetch data from API following clean architecture
     */
    fun getProducts() {
        dataRepository.getProducts(object : DataRepository.OnListData {
            override fun onSuccess(data: BaseModel?) {
                listOfProducts.value = data
            }

            override fun onFailure() {
                //REQUEST FAILED
            }
        })
    }
}