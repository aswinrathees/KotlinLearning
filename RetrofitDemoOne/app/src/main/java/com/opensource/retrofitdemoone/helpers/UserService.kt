package com.opensource.retrofitdemoone.helpers

import com.opensource.retrofitdemoone.model.UserDetails
import com.opensource.retrofitdemoone.model.UserDetailsItem
import retrofit2.Response
import retrofit2.http.*

interface UserService {

    @GET("todos/")
    suspend fun getUsers(): Response<UserDetails>

    @GET("todos/")
    suspend fun getUsersSorted(@Query("userId") userId: Int): Response<UserDetails>

    @GET("todos/{id}")
    suspend fun getUserById(@Path(value = "id") id: Int): Response<UserDetailsItem>

    @POST("posts")
    suspend fun uploadUser(@Body userDetails: UserDetailsItem) : Response<UserDetailsItem>
}