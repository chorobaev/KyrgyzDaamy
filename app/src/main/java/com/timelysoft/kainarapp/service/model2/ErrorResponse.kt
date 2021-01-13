package com.timelysoft.kainarapp.service.model2

import com.google.gson.annotations.SerializedName

data class ErrorResponse (
    @SerializedName("status")
    val status: Int,
    @SerializedName("errors")
    val errors: HashMap<String, List<String>>
)