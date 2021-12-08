package br.com.amd.githubimagecatcher.data.mappers

import br.com.amd.githubimagecatcher.data.local.datasource.model.AvatarEntity
import br.com.amd.githubimagecatcher.domain.model.Image

fun AvatarEntity.toDomain() = Image(id = id, name = name, url = url)

fun Image.toAvatarEntity() = AvatarEntity(id = id, name = name, url = url)