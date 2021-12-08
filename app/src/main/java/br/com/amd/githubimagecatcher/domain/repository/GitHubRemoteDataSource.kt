package br.com.amd.githubimagecatcher.domain.repository

import br.com.amd.githubimagecatcher.domain.model.Image

interface GitHubRemoteDataSource {
    suspend fun getEmojis(): List<Image>
    suspend fun getAvatar(username: String): Image
}