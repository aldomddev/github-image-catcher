package br.com.amd.githubimagecatcher.data.mappers

import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity
import br.com.amd.githubimagecatcher.domain.model.Emoji

fun EmojiEntity.toDomain() = Emoji(name = name, url = url)

fun List<EmojiEntity>.toDomain() = this.map { it.toDomain() }

fun Emoji.toDataEntity() = EmojiEntity(name = name, url = url)

fun List<Emoji>.toDataEntity() = this.map { it.toDataEntity() }