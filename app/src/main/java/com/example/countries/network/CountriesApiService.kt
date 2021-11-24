package com.example.countries.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import java.util.*


private const val BASE_URL =
"    https://countriesnow.space/api/v0.1/countries/flag/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()




interface CountriesApiService {
    @GET("images")
    suspend fun getPhotos() : List<ContriesPhoto>
}

object CountriesApi {
    val retrofitService: CountriesApiService by lazy {
        retrofit.create(CountriesApiService::class.java) }
}