package com.example.chucknorristest.di.module

import android.content.Context
import com.example.chucknorristest.model.ChuckNorrisAPI
import com.example.chucknorristest.model.Network
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    fun provideNetwork(api: ChuckNorrisAPI): Network{
        return Network(api)
    }

    @Provides
    @Singleton
    fun provideChuckNorrisAPI(client: OkHttpClient): ChuckNorrisAPI{
        return Retrofit.Builder()
            .client(client)
            .baseUrl("http://api.icndb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ChuckNorrisAPI::class.java)
    }

    @Provides
    fun provideOKHTTPClient(cache: Cache,
        loggerInterceptor: Interceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(loggerInterceptor)
            .build()
    }

    @Provides
    fun provideCache(context: Context)=
        Cache(context.cacheDir, 5*1024L)


    @Provides
    fun provideLoggerInterceptor(): Interceptor{
        val httLogger = HttpLoggingInterceptor()
        httLogger.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return httLogger
    }
}