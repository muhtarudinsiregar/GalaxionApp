package com.example.ardin.galaxionapps

import com.example.ardin.galaxionapps.data.model.Planetary
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NasaApi {

    @GET("/planetary/apod?date=2018-02-17&api_key=90OiqW4LdWuXD34EGu63UicoKmpj9wvXy1z4F0CG")
    fun getPlanetary(): Call<Planetary>
}