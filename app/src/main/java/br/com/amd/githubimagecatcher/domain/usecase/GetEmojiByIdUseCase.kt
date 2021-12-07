package br.com.amd.githubimagecatcher.domain.usecase

import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import java.lang.Exception
import javax.inject.Inject

class GetEmojiByIdUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) {
    suspend operator fun invoke(id: Int) : Result<Emoji> = try {
        Result.success(gitHubRepository.getEmojiById(id = id))
    } catch (error: Exception) {
        Result.failure(error)
    }
}