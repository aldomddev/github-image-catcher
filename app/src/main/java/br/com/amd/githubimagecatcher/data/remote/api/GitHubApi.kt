package br.com.amd.githubimagecatcher.data.remote.api

import br.com.amd.githubimagecatcher.data.remote.EmojiListResponse
import retrofit2.http.GET

interface GitHubApi {

    @GET("emojis")
    suspend fun getEmojis(): EmojiListResponse
}