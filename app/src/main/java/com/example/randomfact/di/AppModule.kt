package com.example.randomfact.di

import com.example.randomfact.data.randomApi
import com.example.randomfact.data.randomRepo
import com.example.randomfact.data.randomRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getRandomApi(): randomApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://172.25.96.1:8080")
            .build()
            .create(randomApi::class.java)
    }

    @Provides
    @Singleton
    fun getRandomRepo(api: randomApi): randomRepoImpl {
        return randomRepoImpl(api)
    }
}