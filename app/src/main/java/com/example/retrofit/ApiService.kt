package com.example.retrofit

import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/users")
    fun getData(): Observable<List<User>>

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"

        private val client = OkHttpClient
            .Builder()
            .build()

        private val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(ApiService::class.java)

        fun buildService(): ApiService {
            return retrofit
        }
    }
}