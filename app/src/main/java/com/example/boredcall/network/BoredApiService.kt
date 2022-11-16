package com.example.boredcall.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://www.boredapi.com/api/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface BoredApiService{
    @GET("activity")
    suspend fun getBoredActivity() : BoredActivity
}
object BoredApi{
    val retrofitService : BoredApiService by lazy {
        retrofit.create(BoredApiService::class.java)
    }
}