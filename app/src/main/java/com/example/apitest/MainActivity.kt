package com.example.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.apitest.DataClass.MusicData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Creating retrofit Builder
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl(Api.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData = retrofitBuilder.getMusicData("eminem")

        retrofitData.enqueue(object : Callback<MusicData?> {
            //if the api call is success then this method will run
            override fun onResponse(call: Call<MusicData?>, response: Response<MusicData?>) {
                val dataList = response.body()?.data
                val textView = findViewById<TextView>(R.id.tv_textView)
                textView.text = dataList.toString()
                Log.d("onResponse" , "onResponse" + response.body())
            }

            //if the api call is fail then this method is run ( Reason --> Internet Issue )
            override fun onFailure(call: Call<MusicData?>, t: Throwable) {
                Log.d("onFailure" , "onFailure: " + t.message)
            }
        })

    }
}