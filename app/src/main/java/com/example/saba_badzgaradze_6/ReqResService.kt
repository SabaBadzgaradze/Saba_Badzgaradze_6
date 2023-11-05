package com.example.saba_badzgaradze_6

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ReqResService {

    @GET("users")

    fun getPersons(@Query("page") page: Int): Call<Data<List<Person>>>

    @GET("users/{userId}")

    fun getPersonById(@Path("userId") userId: Long): Call<Data<List<Person>>>

}