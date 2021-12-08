package br.com.amd.githubimagecatcher.data.mappers

import br.com.amd.githubimagecatcher.data.remote.model.EmojiListResponse
import br.com.amd.githubimagecatcher.data.remote.model.ImageResponse
import br.com.amd.githubimagecatcher.domain.model.Image

fun ImageResponse.toDomain(): Image {
    return Image(name = name, url = url)
}

fun EmojiListResponse.toDomain(): List<Image> = this.emojis.map { it.toDomain() }