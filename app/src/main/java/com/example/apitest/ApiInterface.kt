package com.example.apitest

import com.example.apitest.DataClass.MusicData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {

    //Giving required Query Object for the api (Type of String as Required)
    @Headers( Api.ApiKey , Api.deaserApi)
    @GET("search")
    fun getMusicData(@Query("q") query: String) : Call<MusicData>
}