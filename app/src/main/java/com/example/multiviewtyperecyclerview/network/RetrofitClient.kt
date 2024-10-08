package com.example.multiviewtyperecyclerview.network

import com.example.multiviewtyperecyclerview.data.database.remote.SearchUserImageList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://dapi.kakao.com"

    //네트워크 요청을 위한 httpClient 구성
    private val okHttpClient by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .addNetworkInterceptor(interceptor)
            .build()
    }


    //retrofit 객체 초기화 및 생성
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //retrofit 클래스로 interface 구현
    val searchUserImageList : SearchUserImageList by lazy {
        retrofit.create(SearchUserImageList::class.java)
    }
}