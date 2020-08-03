package com.cognizant.proficiencyassignment.network

import com.cognizant.proficiencyassignment.model.BaseModel
import retrofit2.Call
import retrofit2.http.GET

interface NetworkApi {
    @GET("/s/2iodh4vg0eortkl/facts.json")
    fun getList(): Call<BaseModel>
}