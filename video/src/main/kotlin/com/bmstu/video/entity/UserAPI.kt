package com.bmstu.video.entity

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserAPI {
    fun initServices() : UserService {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://92.53.65.46:3000")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(UserService::class.java)
    }
}