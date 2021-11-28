package br.com.amd.githubimagecatcher.data.remote

import kotlinx.serialization.Serializable

data class EmojiListResponse(
    @Serializable(with = EmojiListSerializer::class)
    val emojis: List<EmojiResponse>
)
