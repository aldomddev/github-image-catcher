package br.com.amd.githubimagecatcher.domain.repository

import br.com.amd.githubimagecatcher.domain.model.Emoji

interface GitHubLocalDataSource {
    suspend fun getEmojis(): List<Emoji>
    suspend fun getEmojiByName(name: String): Emoji
    suspend fun saveOrUpdate(emoji: Emoji)
    suspend fun saveOrUpdate(emojis: List<Emoji>)
}