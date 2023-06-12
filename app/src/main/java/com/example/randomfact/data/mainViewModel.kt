package com.example.randomfact.data

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class mainViewModel @Inject constructor(
    private val repo: randomRepoImpl
): ViewModel()  {

    val fact = mutableStateOf(Fact())

    init {
        getrandomFact()
    }

    fun getrandomFact() {
        viewModelScope.launch {
            fact.value = repo.getRandomFact()
        }
    }

}