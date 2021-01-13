package com.timelysoft.kainarapp.service.model2

import com.google.gson.annotations.SerializedName
import com.timelysoft.kainarapp.service.model2.response2.File

data class RestaurantResponseCRM(
    @SerializedName("cityId")val cityId: Int,
    @SerializedName("crmId")val crmId: Int,
    @SerializedName("currencyId")val currencyId: String,
    @SerializedName("files")val files: List<File>,
    @SerializedName("id")val id: String,
    @SerializedName("logo")val logo: File,
    @SerializedName("name")val name: String,
    @SerializedName("onlinePaymentSupported")val onlinePaymentSupported: Boolean,
    @SerializedName("restaurantDetail")val restaurantDetail: RestaurantDetail,
    @SerializedName("restaurantGroupId")val restaurantGroupId: String,
    @SerializedName("socialNetworks")val socialNetworks: List<SocialNetwork>,
    @SerializedName("userId")val userId: String,
    @SerializedName("currency") val currency: Currency

)