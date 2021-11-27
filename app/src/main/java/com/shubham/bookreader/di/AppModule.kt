package com.shubham.bookreader.di

import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.google.firebase.firestore.FirebaseFirestore
import com.shubham.bookreader.BookReaderApplication
import com.shubham.bookreader.network.BooksApi
import com.shubham.bookreader.repository.FireRepository
import com.shubham.bookreader.utils.Constants
import com.shubham.bookreader.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideFireBookRepository()
            = FireRepository(queryBook = FirebaseFirestore.getInstance()
        .collection("books"))


    @Provides
    @Singleton
    fun provideHttpClientBuilder(): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(BookReaderApplication.applicationContext()))
            .build()
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.newBuilder().build())
            .build()

    @Provides
    @Singleton
    fun provideNewsApi(retrofit: Retrofit): BooksApi =
        retrofit.create(BooksApi::class.java)


}