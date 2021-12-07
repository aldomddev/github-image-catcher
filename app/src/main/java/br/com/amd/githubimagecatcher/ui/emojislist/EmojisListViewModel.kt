package br.com.amd.githubimagecatcher.ui.emojislist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.amd.githubimagecatcher.domain.usecase.GetEmojisUseCase
import br.com.amd.githubimagecatcher.ui.common.toLiveData
import br.com.amd.githubimagecatcher.ui.mappers.toUiVO
import br.com.amd.githubimagecatcher.ui.model.EmojiVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class EmojisListViewModel @Inject constructor (
    private val getEmojisUseCase: GetEmojisUseCase
) : ViewModel() {

    init {
        getEmojis()
    }

    private val _viewState = MutableLiveData<ViewState<List<EmojiVO>>>()
    val viewState = _viewState.toLiveData()

    private fun getEmojis() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getEmojisUseCase()
            result.onSuccess { emojis ->
                _viewState.postValue(ViewState.Loaded(data = emojis.toUiVO()))
            }
            result.onFailure { error ->
                Timber.e(error)
                _viewState.postValue(ViewState.Error)
            }
        }
    }

    sealed class ViewState<out T> {
        object Loading : ViewState<Nothing>()
        data class Loaded<T>(val data: T) : ViewState<T>()
        object Error : ViewState<Nothing>()
    }
}