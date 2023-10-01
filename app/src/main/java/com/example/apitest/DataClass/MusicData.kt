package com.example.apitest.DataClass

import com.example.apitest.DataClass.Data

data class MusicData(
    val `data`: List<Data>,
    val next: String,
    val total: Int
)