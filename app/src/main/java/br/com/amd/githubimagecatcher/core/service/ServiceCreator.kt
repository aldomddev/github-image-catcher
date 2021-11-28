package br.com.amd.githubimagecatcher.core.service

import okhttp3.OkHttpClient
import retrofit2.Converter
import retrofit2.Retrofit

class ServiceCreator(
    private val client: OkHttpClient,
    private val factoryList: List<Converter.Factory> = emptyList()
) {
    inline fun <reified T> create(baseUrl: String) = create(T::class.java, baseUrl)

    fun <T> create(type: Class<T>, baseUrl: String): T {
        return Retrofit.Builder().apply {
            baseUrl(baseUrl)
            client(client)
            converterFactories().addAll(factoryList)
        }.build().create(type)
    }
}