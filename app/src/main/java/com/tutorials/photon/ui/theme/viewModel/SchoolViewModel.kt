package com.tutorials.photon.ui.theme.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorials.photon.ui.theme.network.Repository
import com.tutorials.photon.ui.theme.network.School
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

class SchoolViewModel(
    val repository: Repository
) : ViewModel() {
    private val _schoolData: MutableLiveData<List<School>?> = MutableLiveData()
    val schoolData: LiveData<List<School>?> = _schoolData

    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _schoolData.value = null
    }

    fun getSchoolData() = viewModelScope.launch(exceptionHandler) {
        supervisorScope {
            _schoolData.value = repository.getSchoolData()
        }
    }
}