package com.example.data

import com.example.domain.Repository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val service: QuoteService
) : Repository {



    override suspend fun loadQuote(): Pair<Boolean, String> {
        return   try {
            val quote = service.Quote().quote
            Pair(true, quote)
        } catch (e: Exception) {
            Pair(false, e.message ?: "error")
        }
    }
    override suspend fun loadTitle(): Pair<Boolean, String> {
        return   try {
            val author = service.Quote().author
            Pair(true, author)
        } catch (e: Exception) {
            Pair(false, e.message ?: "error")
        }
    }
}