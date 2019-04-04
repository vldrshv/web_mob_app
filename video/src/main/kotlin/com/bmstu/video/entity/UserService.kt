package com.bmstu.video.entity

import retrofit2.Call
import retrofit2.http.*

interface UserService {
    /**
     * Возвращает пользователя в формате JSON
     */
    @GET("api/v1/users/email?")
    fun getUser(@Query("email") email: String) : Call<UserInfo>
}