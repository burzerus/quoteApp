package com.example.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import com.example.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val innerLiveData = MutableLiveData<String>()
    val liveData: LiveData<String>
        get() = innerLiveData

    private val innerTitleLiveData = MutableLiveData<String>()
    val titleLiveData: LiveData<String>
        get() = innerTitleLiveData

    private val viewModelScope = CoroutineScope(SupervisorJob() +
            Dispatchers.Main.immediate)

    fun load() {
        viewModelScope.launch {
            val authorDeferred = async { repository.loadTitle().second }
            val quoteDeferred = async { repository.loadQuote().second }

            val author = authorDeferred.await()
            val quote = quoteDeferred.await()

            innerTitleLiveData.value = author
            innerLiveData.value = quote
        }
    }
}
