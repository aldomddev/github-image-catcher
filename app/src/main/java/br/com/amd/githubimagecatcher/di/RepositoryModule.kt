package br.com.amd.githubimagecatcher.di

import br.com.amd.githubimagecatcher.data.remote.datasource.GitHubLocalDataSourceImpl
import br.com.amd.githubimagecatcher.data.remote.datasource.GitHubRemoteDataSourceImpl
import br.com.amd.githubimagecatcher.data.repository.GitHubRepositoryImpl
import br.com.amd.githubimagecatcher.domain.repository.GitHubLocalDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRemoteDataSource
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindGitHubRemoteDataSource(gitHubRemoteDataSource: GitHubRemoteDataSourceImpl): GitHubRemoteDataSource

    @Singleton
    @Binds
    abstract fun bindGitHubLocalDataSource(gitHubLocalDataSource: GitHubLocalDataSourceImpl): GitHubLocalDataSource

    @Singleton
    @Binds
    abstract fun bindGitHubRepository(gitHubRepository: GitHubRepositoryImpl): GitHubRepository
}