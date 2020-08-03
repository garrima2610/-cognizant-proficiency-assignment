package com.cognizant.proficiencyassignment.model

import com.google.gson.annotations.SerializedName

data class BaseModel (

    @SerializedName("title") val title : String,
    @SerializedName("rows") val rows : List<Rows>
)