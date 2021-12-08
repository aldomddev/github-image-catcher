package br.com.amd.githubimagecatcher.ui.mappers

import br.com.amd.githubimagecatcher.domain.model.Image
import br.com.amd.githubimagecatcher.ui.model.EmojiVO

fun Image.toUiVO() = EmojiVO(id = id, url = url)

fun List<Image>.toUiVO() = this.map { it.toUiVO() }