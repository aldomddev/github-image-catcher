package br.com.amd.githubimagecatcher.data.remote.model

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

@ExperimentalSerializationApi
@Serializable
data class ImageResponse(
    @JsonNames("login")
    val name: String,
    @JsonNames("avatar_url")
    val url: String
)
