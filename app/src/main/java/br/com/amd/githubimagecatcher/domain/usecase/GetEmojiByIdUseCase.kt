package br.com.amd.githubimagecatcher.domain.usecase

import br.com.amd.githubimagecatcher.domain.model.Image
import br.com.amd.githubimagecatcher.domain.repository.GitHubRepository
import java.lang.Exception
import javax.inject.Inject

class GetEmojiByIdUseCase @Inject constructor(
    private val gitHubRepository: GitHubRepository
) {
    suspend operator fun invoke(id: Int) : Result<Image> = try {
        Result.success(gitHubRepository.getEmojiById(id = id))
    } catch (error: Exception) {
        Result.failure(error)
    }
}