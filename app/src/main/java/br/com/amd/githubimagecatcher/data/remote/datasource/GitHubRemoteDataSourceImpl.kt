package br.com.amd.githubimagecatcher.data.remote.datasource

import br.com.amd.githubimagecatcher.data.mappers.toDomain
import br.com.amd.githubimagecatcher.data.remote.api.GitHubApi
import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubRemoteDataSource
import javax.inject.Inject

class GitHubRemoteDataSourceImpl @Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubRemoteDataSource {

    override suspend fun getEmojis(): List<Emoji> {
        return gitHubApi.getEmojis().toDomain()
    }
}