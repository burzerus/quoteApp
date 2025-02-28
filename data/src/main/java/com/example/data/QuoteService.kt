package com.example.data

import retrofit2.http.GET

interface QuoteService {

    //https://animechan.xyz/api/random

    //https://qapi.vercel.app/docs
//https://api.weatherapi.com/v1/current.json?key=357959be569341c6b9c171147230911&q=Moscow&aqi=no
    @GET("api/random")

    suspend fun Quote() : QuoteCloud
}