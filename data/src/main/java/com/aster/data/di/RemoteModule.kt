package com.aster.data.di

import com.aster.data.BuildConfig
import com.aster.data.retrofit.NewsRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author ichsanachmad
 */

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    private const val API_KEY = "apiKey"

    @Provides
    fun providesHttpLoggingInterceptors(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BASIC
        }
    }

    @Provides
    fun providesOkHttpBuilder(logging: HttpLoggingInterceptor): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .connectTimeout(10000, TimeUnit.MILLISECONDS)
            .readTimeout(10000, TimeUnit.MILLISECONDS)


    @Provides
    fun providesOkHttpNews(okHttpClient: OkHttpClient.Builder): OkHttpClient {
        val httpUrl = HttpUrl.Builder()
            .setQueryParameter(API_KEY, BuildConfig.API_KEY)
            .build()

        return okHttpClient
            .addInterceptor { chain ->
                val request = chain.request().newBuilder().url(httpUrl).build()
                chain.proceed(request)
            }.build()
    }

    @Provides
    fun providesRetrofitBuilder(): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @NewsRetrofit
    fun providesRetrofitNews(okHttpClientNews: OkHttpClient, retrofitBuilder: Retrofit.Builder): Retrofit {
        return retrofitBuilder
            .client(okHttpClientNews)
            .baseUrl(BuildConfig.API_URL).build()
    }
}