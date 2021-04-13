package com.atritripathi.musk.di

import android.app.Application
import androidx.room.Room
import com.atritripathi.musk.BuildConfig
import com.atritripathi.musk.data.DefaultMuskRepository
import com.atritripathi.musk.data.MuskRepository
import com.atritripathi.musk.data.source.local.MuskDatabase
import com.atritripathi.musk.data.source.local.MuskDatabase.Companion.DATABASE_NAME
import com.atritripathi.musk.data.source.remote.MuskApi
import com.atritripathi.musk.data.source.remote.MuskApi.Companion.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(moshi: Moshi): Retrofit {
        val logging = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) BODY else NONE   // Only log Json while in debug mode
        }
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideRemoteApi(retrofit: Retrofit): MuskApi =
        retrofit.create(MuskApi::class.java)

    @Provides
    @Singleton
    fun provideDatabase(app: Application): MuskDatabase =
        Room.databaseBuilder(app, MuskDatabase::class.java, DATABASE_NAME)
            .build()

    /**
     * Generally, we don't need to provide a Repository because we are already providing
     * the `MuskApi` and `MuskDatabase`, and so Dagger-Hilt already knows how to create it.
     * But because we are using Repository as an Interface i.e. MuskInterface in our ViewModels,
     * we need to provide a concrete implementation of it like `DefaultMuskRepository` and
     * explicitly cast it as `MuskRepository`.
     */
    @Provides
    @Singleton
    fun provideDefaultMuskRepository(
        api: MuskApi,
        db: MuskDatabase
    ) = DefaultMuskRepository(api, db) as MuskRepository

}