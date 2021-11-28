package br.com.amd.githubimagecatcher.domain.usecase

import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import java.lang.Exception
import javax.inject.Inject

class GetEmojisUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) {
    suspend operator fun invoke() : Result<List<Emoji>> = try {
        Result.success(gitHubRepository.getEmojis())
    } catch (error: Exception) {
        Result.failure(error)
    }
}