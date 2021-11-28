package br.com.amd.githubimagecatcher.domain.repository

import br.com.amd.githubimagecatcher.domain.model.Emoji

interface GitHubRepository {
    suspend fun getEmojis(): List<Emoji>
}