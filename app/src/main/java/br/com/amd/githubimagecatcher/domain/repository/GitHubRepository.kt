package br.com.amd.githubimagecatcher.domain.repository

import br.com.amd.githubimagecatcher.domain.model.Image

interface GitHubRepository {
    suspend fun getEmojis(): List<Image>
    suspend fun getEmojiById(id: Int): Image
    suspend fun getAvatar(username: String): Image
    suspend fun saveAvatar(avatar: Image)
    suspend fun deleteAvatar(avatar: Image)
}