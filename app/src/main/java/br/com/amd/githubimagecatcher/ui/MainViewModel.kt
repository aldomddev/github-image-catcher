package br.com.amd.githubimagecatcher.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.amd.githubimagecatcher.domain.usecase.GetEmojisUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getEmojisUseCase: GetEmojisUseCase
) : ViewModel() {
    init {
        getEmojis()
    }

    private fun getEmojis() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getEmojisUseCase().fold(
                onSuccess = { emojis ->
                    println("Yes!")
                },
                onFailure = { error ->
                    Timber.e(error, "Failed to fetch emojis list.")
                }
            )
        }
    }
}