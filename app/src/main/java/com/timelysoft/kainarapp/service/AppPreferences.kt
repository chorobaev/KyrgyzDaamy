package com.timelysoft.kainarapp.service

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.timelysoft.kainarapp.service.db.entity.BasketEntity
import com.timelysoft.kainarapp.service.model.TokenModel
import com.timelysoft.kainarapp.service.model2.response2.MenuItem
import com.timelysoft.kainarapp.service.model2.response2.OnlinePaymentResponse


object AppPreferences {

    var change: Boolean = false

    const val baseUrlCRM = "https://kaynar-test.timelysoft.org:8041/"
    const val baseUrl = "https://delivery-test.timelysoft.org:8051/"
    const val HEADER_CACHE_CONTROL = "Cache-Control"

    fun group() = "242faadb-8abe-421c-ffa6-08d89114aa62"

    private const val NAME = "KainarApp"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    fun updateToken(tokenResponse: TokenModel) {
        accessToken = tokenResponse.accessToken
        refreshToken = tokenResponse.refreshToken
    }

    fun saveToken(tokenResponse: TokenModel) {
        isLogined = true
        accessToken = tokenResponse.accessToken
        refreshToken = tokenResponse.refreshToken
    }

    var categoryId: String?
        set(value) = preferences.edit {
            it.putString("categoryId", value)
        }
        get() = preferences.getString("categoryId", "")


    var bankPay: Boolean
        get() = preferences.getBoolean("bankPay", false)
        set(value) = preferences.edit() {
            it.putBoolean("bankPay", value)
        }


    var amount: Int
        get() = preferences.getInt("amount", 0)
        set(value) = preferences.edit {
            it.putInt("amount", value)
        }

    fun clear() {
        isLogined = false
        accessToken = ""
        refreshToken = ""
        login = ""
        name = ""
        surname = ""
        phone = ""
    }


    var isLogined: Boolean
        get() = preferences.getBoolean("isLogined", false)
        set(value) = preferences.edit {
            it.putBoolean("isLogined", value)
        }

    var accessToken: String?
        get() = preferences.getString("accessToken", "")
        set(value) = preferences.edit {
            it.putString("accessToken", value)
        }

    var login: String?
        get() = preferences.getString("login", "")
        set(value) = preferences.edit {
            it.putString("login", value)
        }

    var started: Boolean
        get() = preferences.getBoolean("started", false)
        set(value) = preferences.edit() {
            it.putBoolean("started", value)
        }

    var refreshToken: String?
        get() = preferences.getString("refreshToken", "")
        set(value) = preferences.edit {
            it.putString("refreshToken", value)
        }

    var language: String?
        get() = preferences.getString("language", "ru")
        set(value) = preferences.edit {
            it.putString("language", value)
        }


    var restaurant: String
        get() = preferences.getString("restaurant", "")!!
        set(value) = preferences.edit {
            it.putString("restaurant", value)
        }

    var restaurantPhoto: String
        get() = preferences.getString("restaurantPhoto", "")!!
        set(value) = preferences.edit {
            it.putString("restaurantPhoto", value)
        }

    var restaurantLogo: String
        get() = preferences.getString("restaurantPhotoLogo", "")!!
        set(value) = preferences.edit {
            it.putString("restaurantPhotoLogo", value)
        }

    var restaurantCRM: Int
        get() = preferences.getInt("restaurantCRM", -1)
        set(value) = preferences.edit {
            it.putInt("restaurantCRM", value)
        }

    var globalId: String
        get() {
            val data = preferences.getString("globalId", "")
            return if (data != null) return data else ""

        }
        set(value) = preferences.edit {
            it.putString("globalId", value)
        }

    var name: String
        get() {
            val data = preferences.getString("name", "")
            return if (data != null) return data else ""

        }
        set(value) = preferences.edit {
            it.putString("name", value)
        }

    var surname: String
        get() {
            val data = preferences.getString("Surnames", "")
            return if (data != null) return data else ""

        }
        set(value) = preferences.edit {
            it.putString("Surnames", value)
        }

    var phone: String
        get() {
            val data = preferences.getString("phone", "")
            return if (data != null) return data else ""

        }
        set(value) = preferences.edit {
            it.putString("phone", value)
        }

    var lastOrderType: Int
        get() = preferences.getInt("lastOrderType", -1)
        set(value) = preferences.edit {
            it.putInt("lastOrderType", value)
        }


    var lastOrderId: String
        get() {
            val data = preferences.getString("lastOrderId", "")
            return if (data != null) return data else ""

        }
        set(value) = preferences.edit {
            it.putString("lastOrderId", value)
        }

    var lastOrderRestaurantId: String
        get() {
            val data = preferences.getString("lastOrderRestaurantId", "")
            return if (data != null) return data else ""

        }
        set(value) = preferences.edit {
            it.putString("lastOrderRestaurantId", value)
        }


    fun version(restaurantId: String, version: String) {
        preferences.edit {
            it.putString("restaurantId", version)

        }
    }


    fun version(): String? {
        return preferences.getString("restaurantId", "")
    }


}