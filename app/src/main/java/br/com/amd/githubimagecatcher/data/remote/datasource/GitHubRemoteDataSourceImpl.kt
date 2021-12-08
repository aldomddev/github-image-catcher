package br.com.amd.githubimagecatcher.data.remote.datasource

import br.com.amd.githubimagecatcher.data.mappers.toDomain
import br.com.amd.githubimagecatcher.data.remote.api.GitHubApi
import br.com.amd.githubimagecatcher.domain.model.Image
import br.com.amd.githubimagecatcher.domain.repository.GitHubRemoteDataSource
import javax.inject.Inject

class GitHubRemoteDataSourceImpl @Inject constructor(
    private val gitHubApi: GitHubApi
) : GitHubRemoteDataSource {

    override suspend fun getEmojis(): List<Image> {
        return gitHubApi.getEmojis().toDomain()
    }

    override suspend fun getAvatar(username: String): Image {
        return gitHubApi.getAvatar(username = username).toDomain()
    }
}