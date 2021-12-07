package br.com.amd.githubimagecatcher.domain.usecase

import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import java.lang.Exception
import javax.inject.Inject

class GetEmojisUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) {
    suspend operator fun invoke() : Result<List<Emoji>> = try {
        val emojis = gitHubRepository.getEmojis()
        Result.success(emojis)
    } catch (error: Exception) {
        Result.failure(error)
    }
}