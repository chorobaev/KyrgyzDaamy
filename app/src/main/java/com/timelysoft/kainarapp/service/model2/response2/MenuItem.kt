package com.timelysoft.kainarapp.service.model2.response2

import com.google.gson.annotations.SerializedName


data class MenuItem(
        @SerializedName("code")val code: Int,
        @SerializedName("description")val description: String?,
        @SerializedName("isHit")val isHit: Int,
        @SerializedName("modifierGroups") var modifierGroups: List<BaseModifierGroup>,
        @SerializedName("name")val name: String,
        @SerializedName("price")val price: Int,
        @SerializedName("recipe")val recipe: String,
        @SerializedName("rests")val rests: Int,
        @SerializedName("weight")val weight: Int,
        var amount: Int,
        var isSame : Boolean,
        var priceWithMod : Int,
        var positionInList : Int
)