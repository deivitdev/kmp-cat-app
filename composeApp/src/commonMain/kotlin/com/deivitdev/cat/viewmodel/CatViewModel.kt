package com.deivitdev.cat.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deivitdev.cat.model.CatApi
import com.deivitdev.cat.model.CatImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CatViewModel(private val catApi: CatApi) : ViewModel() {

    private val _isLoading = MutableStateFlow(false)
    var isLoading: StateFlow<Boolean> get() = _isLoading
        set(value) {}

    private val _images = MutableStateFlow<List<CatImage>?>(null)
    val images: StateFlow<List<CatImage>?> get() = _images

    private val _fact = MutableStateFlow<String?>(null)
    val fact: StateFlow<String?> get() = _fact

    fun loadCatData() {
        viewModelScope.launch {
            _isLoading.value = true
            val images = catApi.get10RandomCatImages()
            val fact = catApi.getRandomCatFact()
            _images.value = images
            _fact.value = fact.fact
            _isLoading.value = false
        }
    }
}