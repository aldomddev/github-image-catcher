package br.com.amd.githubimagecatcher.data.mappers

import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity
import br.com.amd.githubimagecatcher.domain.model.Image

fun EmojiEntity.toDomain() = Image(id = id, name = name, url = url)

fun List<EmojiEntity>.toDomain() = this.map { it.toDomain() }

fun Image.toEmojiEntity() = EmojiEntity(id = id, name = name, url = url)

fun List<Image>.toEmojiEntity() = this.map { it.toEmojiEntity() }