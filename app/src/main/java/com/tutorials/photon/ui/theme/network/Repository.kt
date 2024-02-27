package com.tutorials.photon.ui.theme.network

open class Repository(private val service: Service){

    suspend fun getSchoolData(): List<School>?{
        val response =service.getSchool()
        return if (response.isSuccessful){
            response.body()
        } else{
            null
        }
    }
}