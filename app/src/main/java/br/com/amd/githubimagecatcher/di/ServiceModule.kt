package br.com.amd.githubimagecatcher.di

import br.com.amd.githubimagecatcher.core.service.ServiceCreator
import br.com.amd.githubimagecatcher.data.Constants
import br.com.amd.githubimagecatcher.data.remote.api.GitHubApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Converter
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
//    @ExperimentalSerializationApi
//    @Provides
//    fun provideJsonConverterFactories(): Converter.Factory {
//        return Json.asConverterFactory(MediaType.get("application/json"))
//    }

    @Provides
    fun provideJson(): Json {
        return Json { ignoreUnknownKeys = true }
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient()

    @ExperimentalSerializationApi
    @Singleton
    @Provides
    fun provideServiceCreator(client: OkHttpClient, json: Json): ServiceCreator {
        return ServiceCreator(client = client, factoryList = listOf(json.asConverterFactory(MediaType.get("application/json"))))
    }

    @Singleton
    @Provides
    fun provideGitHubService(serviceCreator: ServiceCreator): GitHubApi {
        return serviceCreator.create(GitHubApi::class.java, Constants.GITHUB_BASE_URL)
    }
}