package com.cognizant.proficiencyassignment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cognizant.proficiencyassignment.model.BaseModel
import com.cognizant.proficiencyassignment.repository.DataRepository
import org.koin.standalone.KoinComponent

class CountryViewModel(val dataRepository: DataRepository) : ViewModel(), KoinComponent {

    var listOfProducts = MutableLiveData<BaseModel>()

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