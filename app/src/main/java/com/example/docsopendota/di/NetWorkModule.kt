package com.example.docsopendota.di

import com.example.docsopendota.data.remote.NetWorkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetWorkModule {

    @Singleton
    @Provides
    fun provideHeroesApiService(netWorkClient: NetWorkClient) =
        netWorkClient.provideHeroesApiService()
}