package com.tutorials.photon.ui.theme.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tutorials.photon.ui.theme.network.School
import com.tutorials.photon.ui.theme.network.Service
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class SchoolViewModel(
    val service: Service
) : ViewModel() {
    private val _schoolData: MutableLiveData<Response<List<School>>> = MutableLiveData()
    val schoolData: LiveData<Response<List<School>>> = _schoolData

    fun getSchoolData() = viewModelScope.launch(Dispatchers.IO) {
        withContext(Dispatchers.Main) {
            _schoolData.value = service.getSchool()
        }
    }
}