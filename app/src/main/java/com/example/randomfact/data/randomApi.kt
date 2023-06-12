package com.example.randomfact.data

import retrofit2.http.GET

interface randomApi {

    @GET("/randomFact")
    suspend fun getRandomFact(): Fact

}