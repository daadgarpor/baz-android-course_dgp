package com.example.criptobitsoproyectwz.di

import android.content.Context
import androidx.room.Room
import com.example.criptobitsoproyectwz.Util.Constans
import com.example.criptobitsoproyectwz.data.Room.CriptoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    @Singleton
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, CriptoDatabase::class.java, Constans.QUOTE_DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideCriptoDao(database: CriptoDatabase) = database.criptoDao()
}