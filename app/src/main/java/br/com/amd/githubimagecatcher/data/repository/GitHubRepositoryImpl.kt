package br.com.amd.githubimagecatcher.data.repository

import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubLocalDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRemoteDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource,
    private val gitHubLocalDataSource: GitHubLocalDataSource
) : GitHubRepository {

    override suspend fun getEmojis(): List<Emoji> {
        val localEmojisList = gitHubLocalDataSource.getEmojis()
        return if (localEmojisList.isNotEmpty()) {
            localEmojisList
        } else {
            val remoteEmojisList = gitHubRemoteDataSource.getEmojis()
            gitHubLocalDataSource.saveOrUpdate(emojis = remoteEmojisList)
            remoteEmojisList
        }
    }

    override suspend fun getEmojiById(id: Int): Emoji {
        return gitHubLocalDataSource.getEmojiById(id = id)
    }
}