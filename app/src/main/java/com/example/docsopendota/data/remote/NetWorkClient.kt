package com.example.docsopendota.data.remote

import com.example.docsopendota.data.remote.apiservices.HeroesApiServices
import com.example.docsopendota.data.remote.apiservices.OkHttp
import com.example.docsopendota.data.remote.apiservices.RetrofitClient
import javax.inject.Inject

class NetWorkClient @Inject constructor(
    retrofitClient: RetrofitClient,
    okHttpClient: OkHttp
) {

    private val provideRetrofit = retrofitClient.provideRetrofit(okHttpClient.provideOkHttpClient())

    fun provideHeroesApiService() = provideRetrofit.create(HeroesApiServices::class.java)
}