package com.tutorials.photon.ui.theme.network

import retrofit2.http.GET
import retrofit2.Response

interface Service {

    @GET("resource/s3k6-pzi2.json")
    suspend fun getSchool(): Response<List<School>>

}