package com.aster.domain.di

import com.aster.domain.annotation.DispatcherIO
import com.aster.domain.annotation.DispatcherMain
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * @author ichsanachmad
 */
@Module
@InstallIn(SingletonComponent::class)
object DispatcherModule {

    @Provides
    @DispatcherIO
    fun providesDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @DispatcherMain
    fun providesDispatcherMain(): CoroutineDispatcher = Dispatchers.Main
}