package br.com.amd.githubimagecatcher.data.remote.model

import br.com.amd.githubimagecatcher.data.remote.serializers.EmojiListSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable(with = EmojiListSerializer::class)
data class EmojiListResponse(
    @Transient val emojis: List<EmojiResponse> = listOf()
)