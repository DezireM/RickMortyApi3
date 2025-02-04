package com.example.rickmortyapi.module

import com.example.rickmortyapi.data.network.api.CharacterApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single {
        provideRetrofit(get())
    }

    single {
        provideApiService(get())
    }

    single {
        provideOkHttpClient(get())
    }

    single {
        provideLoggingInterceptor()
    }
}

private const val TIMEOUT_DURATION = 10L

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

fun provideApiService(retrofit: Retrofit): CharacterApiService =
    retrofit.create(CharacterApiService::class.java)

fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder()
        .readTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .writeTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .connectTimeout(TIMEOUT_DURATION, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .build()

fun provideLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
