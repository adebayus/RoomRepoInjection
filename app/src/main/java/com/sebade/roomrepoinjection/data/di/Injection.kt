package com.sebade.roomrepoinjection.data.di

import android.content.Context
import com.sebade.roomrepoinjection.data.NewsRepository
import com.sebade.roomrepoinjection.data.local.room.NewsDatabase
import com.sebade.roomrepoinjection.data.remote.retrofit.ApiConfig
import com.sebade.roomrepoinjection.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): NewsRepository {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
        return NewsRepository.getInstance(apiService, dao, appExecutors)
    }
}