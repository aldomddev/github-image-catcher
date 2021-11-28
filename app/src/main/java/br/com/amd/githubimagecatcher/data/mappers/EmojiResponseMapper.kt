package br.com.amd.githubimagecatcher.data.mappers

import br.com.amd.githubimagecatcher.data.remote.model.EmojiListResponse
import br.com.amd.githubimagecatcher.data.remote.model.EmojiResponse
import br.com.amd.githubimagecatcher.domain.model.Emoji

fun EmojiResponse.toDomain(): Emoji {
    return Emoji(name, url)
}

fun EmojiListResponse.toDomain(): List<Emoji> = this.emojis.map { it.toDomain() }