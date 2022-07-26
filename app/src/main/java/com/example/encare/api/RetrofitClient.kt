package com.example.encare.api

import com.example.encare.DataLocal.SharedPreferencesOptimal
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Sington Pattern
object RetrofitClient {
    // lay token trong bo nho
    private val TOKEN = SharedPreferencesOptimal.get("TOKEN", String::class.java)

//    private const val BASE_URL = "http://192.168.1.7:8081/"
    private const val BASE_URL = "http://192.168.1.109:8081/"
//    private const val BASE_URL = "http://10.0.2.2:8081/"

    // test catching data
    private val READ_TIMEOUT = 5000
    private val REQUEST_TIMEOUT = 5000
    private val CONNECT_TIMEOUT = 5000
    private val CACHE_CONTROL: String = "Cache-Control"

    // create logger
    private val logger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    // create OkHttpClient
    //Cu
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(logger)
        .addInterceptor { chain ->
            val original = chain.request()
            val requestBuilder = original.newBuilder()
                .addHeader("Authorization", TOKEN)
            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    // lazy: Khi nao can moi tao
    val instance: ApiServices by lazy{
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .build()

        retrofit.create(ApiServices::class.java)
    }

}