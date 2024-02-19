package com.tutorials.photon.ui.theme.network

import retrofit2.Response

class ServiceImpl() : Service {
    override suspend fun getSchool(): Response<List<School>> {
        TODO("Not yet implemented")
    }
}