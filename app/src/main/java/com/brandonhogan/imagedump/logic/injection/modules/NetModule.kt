package com.brandonhogan.imagedump.logic.injection.modules

import android.os.Environment
import com.brandonhogan.imagedump.logic.injection.scopes.AppScope
import com.brandonhogan.imagedump.logic.network.RedditAPI
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named

/**
 * @Creator         bhogan
 * @Date            2017-06-29
 * @Description     $PARAM$
 */

@Module
class NetModule {

    @AppScope
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @AppScope
    @Provides
    @Named("cached")
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        val cache = Cache(Environment.getDownloadCacheDirectory(), 10 * 1024 * 1024)
        return OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .cache(cache)
                .build()
    }

    @AppScope
    @Provides
    @Named("non_cached")
    fun provideNonCachedOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .readTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .addInterceptor(interceptor)
                .build()
    }

    @AppScope
    @Provides
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
        return gsonBuilder.create()
    }

    @AppScope
    @Provides
    fun provideReddit(@Named("non_cached") client: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .client(client)
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }


    @AppScope
    @Provides
    fun providesAPI(retrofit: Retrofit): RedditAPI {
        return retrofit.create(RedditAPI::class.java)
    }
}