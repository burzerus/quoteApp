package com.example.monoweather

import com.example.data.QuoteService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Provides
    fun provideService() : QuoteService =
        Retrofit.Builder().baseUrl("https://qapi.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(QuoteService::class.java)

    }
