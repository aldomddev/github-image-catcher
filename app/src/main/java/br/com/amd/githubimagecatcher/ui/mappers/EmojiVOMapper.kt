package br.com.amd.githubimagecatcher.ui.mappers

import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.ui.model.EmojiVO

fun Emoji.toUiVO() = EmojiVO(url = url)

fun List<Emoji>.toUiVO() = this.map { it.toUiVO() }