package br.com.amd.githubimagecatcher.data.remote.model

import br.com.amd.githubimagecatcher.data.remote.serializers.EmojiListSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
data class EmojiListResponse(
    @Serializable(with = EmojiListSerializer::class)
    @Transient
    val emojis: List<EmojiResponse> = listOf()
)