package com.example.countries.network
data class Respons(val error:Boolean, val msg: String, val data: List<ContriesPhoto>)
data class ContriesPhoto
(val name: String, val flag: String
)