package com.example.criptobitsoproyectwz.di

import android.content.Context
import android.os.Build
import androidx.room.Room
import com.example.criptobitsoproyectwz.data.dataSource.CriptoDataSource
import com.example.criptobitsoproyectwz.data.network.BitsoService
import com.example.criptobitsoproyectwz.data.network.CriptosClient
import com.example.criptobitsoproyectwz.data.repository.CriptoRepository
import com.example.criptobitsoproyectwz.data.repository.CriptoRepositoryImpl
import com.example.criptobitsoproyectwz.data.room.CriptoDatabase
import com.example.criptobitsoproyectwz.util.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.Interceptor.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CriptoModule {
    @Binds
    abstract fun providesCriptoRepository(criptoRepositoryImpl: CriptoRepositoryImpl): CriptoRepository

    @Binds
    abstract fun providesCriptoDataSource(criptoClient: CriptosClient): CriptoDataSource

    companion object {

        @Singleton
        @Provides
        fun provideContext(@ApplicationContext context: Context): Context = context.applicationContext

        @Provides
        fun provideBaseUrl(@ApplicationContext context: Context): OkHttpClient =
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().also {
                        it.level = HttpLoggingInterceptor.Level.BODY
                    }
                )
                .addInterceptor(Interceptor { chain ->
                    val newRequest =
                        chain.request().newBuilder().addHeader("User-Agent",
                            String.format(Locale.getDefault(), "%s; %s; Android %s; %s; %s; %s; %s;",
                                 context.applicationContext.packageName,Build.VERSION.CODENAME, Build.VERSION.RELEASE,Build.MODEL, Build.BRAND, Build.DEVICE,
                                Locale.getDefault().language)).build()
                    chain.proceed(newRequest)
                })
                .build()


        @Provides
        fun provideRetrofitInstance(client: OkHttpClient): Retrofit {
            return Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        @Provides
        fun providesCriptoService(retrofit: Retrofit) = retrofit.create<BitsoService>()

        @Singleton
        @Provides
        fun provideRoom(@ApplicationContext context: Context) =
            Room.databaseBuilder(context, CriptoDatabase::class.java, Constants.QUOTE_DATABASE_NAME).build()

        @Singleton
        @Provides
        fun provideCriptoDao(database: CriptoDatabase) = database.criptoDao()
    }
}
