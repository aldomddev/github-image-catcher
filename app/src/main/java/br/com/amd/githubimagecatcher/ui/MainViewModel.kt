package br.com.amd.githubimagecatcher.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.amd.githubimagecatcher.domain.usecase.GetEmojiByIdUseCase
import br.com.amd.githubimagecatcher.domain.usecase.GetEmojisCountUseCase
import br.com.amd.githubimagecatcher.domain.usecase.GetEmojisUseCase
import br.com.amd.githubimagecatcher.ui.common.toLiveData
import br.com.amd.githubimagecatcher.ui.mappers.toUiVO
import br.com.amd.githubimagecatcher.ui.model.EmojiVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getEmojisCountUseCase: GetEmojisCountUseCase,
    private val getEmojiByIdUseCase: GetEmojiByIdUseCase
) : ViewModel() {

    init {
        randomEmoji()
    }

    private val _randomEmoji = MutableLiveData<EmojiVO>()
    val randomEmoji = _randomEmoji.toLiveData()

    fun randomEmoji() {
        viewModelScope.launch(Dispatchers.IO) {
            getEmojisCountUseCase().onSuccess { count ->
                val id = Random.nextInt(1, count)
                getEmojiByIdUseCase(id = id).onSuccess { emoji ->
                    _randomEmoji.postValue(emoji.toUiVO())
                }
            }
        }
    }
}