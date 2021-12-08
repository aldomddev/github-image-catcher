package br.com.amd.githubimagecatcher.data.repository

import br.com.amd.githubimagecatcher.domain.model.Image
import br.com.amd.githubimagecatcher.domain.repository.GitHubLocalDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRemoteDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource,
    private val gitHubLocalDataSource: GitHubLocalDataSource
) : GitHubRepository {

    override suspend fun getEmojis(): List<Image> {
        val localEmojisList = gitHubLocalDataSource.getEmojis()
        return if (localEmojisList.isNotEmpty()) {
            localEmojisList
        } else {
            val remoteEmojisList = gitHubRemoteDataSource.getEmojis()
            gitHubLocalDataSource.saveEmojis(emojis = remoteEmojisList)
            remoteEmojisList
        }
    }

    override suspend fun getEmojiById(id: Int): Image {
        return gitHubLocalDataSource.getEmojiById(id = id)
    }

    override suspend fun getAvatar(username: String): Image {
        return gitHubLocalDataSource.getAvatar(username = username)
    }

    override suspend fun saveAvatar(avatar: Image) {
        gitHubLocalDataSource.saveAvatar(avatar = avatar)
    }

    override suspend fun deleteAvatar(avatar: Image) {
        gitHubLocalDataSource.deleteAvatar(avatar = avatar)
    }
}