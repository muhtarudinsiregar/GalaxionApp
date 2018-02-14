package com.example.ardin.galaxionapps

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiBuilder {
    fun call(): NasaApi {
        val BASE_URL = "https://api.nasa.gov"

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(NasaApi::class.java)
    }
}