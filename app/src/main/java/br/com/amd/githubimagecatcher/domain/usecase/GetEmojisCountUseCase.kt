package br.com.amd.githubimagecatcher.domain.usecase

import javax.inject.Inject

class GetEmojisCountUseCase @Inject constructor(
    private val getEmojisUseCase: GetEmojisUseCase
) {
    suspend operator fun invoke() : Result<Int> {
        return getEmojisUseCase().fold(
            onSuccess = { emojis ->
                Result.success(emojis.size)
            },
            onFailure = { error ->
                Result.failure(error)
            }
        )
    }
}