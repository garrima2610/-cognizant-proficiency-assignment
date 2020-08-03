package com.cognizant.proficiencyassignment.repository

import com.cognizant.proficiencyassignment.model.BaseModel
import com.cognizant.proficiencyassignment.network.NetworkApi
import retrofit2.Call
import retrofit2.Response

class DataRepository(val networkApi: NetworkApi) {

    fun getProducts(onList: OnListData) {
        networkApi.getList().enqueue(object : retrofit2.Callback<BaseModel> {
            override fun onResponse(call: Call<BaseModel>, response: Response<BaseModel>) {
                onList.onSuccess(response.body())
            }

            override fun onFailure(call: Call<BaseModel>, t: Throwable) {
                onList.onFailure()
            }
        })
    }

    interface OnListData {
        fun onSuccess(data: BaseModel?)
        fun onFailure()
    }
}