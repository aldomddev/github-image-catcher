package br.com.amd.githubimagecatcher.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class EmojiResponse(
    val name: String,
    val url: String
)
