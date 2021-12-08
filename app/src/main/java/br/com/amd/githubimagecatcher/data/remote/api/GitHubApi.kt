package br.com.amd.githubimagecatcher.data.remote.api

import br.com.amd.githubimagecatcher.data.remote.model.EmojiListResponse
import br.com.amd.githubimagecatcher.data.remote.model.ImageResponse
import kotlinx.serialization.ExperimentalSerializationApi
import retrofit2.http.GET
import retrofit2.http.Path

@ExperimentalSerializationApi
interface GitHubApi {

    @GET("emojis")
    suspend fun getEmojis(): EmojiListResponse

    @GET("users/{username}")
    suspend fun getAvatar(@Path("username") username: String): ImageResponse
}