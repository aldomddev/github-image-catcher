package br.com.amd.githubimagecatcher.data.repository

import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubRemoteDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubRemoteDataSource: GitHubRemoteDataSource
) : GitHubRepository {
    override suspend fun getEmojis(): List<Emoji> {
        return gitHubRemoteDataSource.getEmojis()
    }
}