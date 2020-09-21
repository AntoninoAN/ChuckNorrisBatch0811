package com.example.chucknorristest.model

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ChuckNorrisAPI {
    //http://api.icndb.com/jokes/random
    @GET("jokes/random")
    suspend fun getMeRandomJoke(): JokesResponse

    //http://api.icndb.com/jokes/random?firstName=John&amp;lastName=Doe

    @GET("jokes/random")
    suspend fun getMeRandomJokeWithName(
        @Query("firstName") firstName: String,
        @Query("lastName") lastName: String
    ): JokesResponse

    @GET("jokes/random/{size}")
    suspend fun getMeRandomEndlessJoke(
        @Path("size") limit: Int = 20
    ): JokeListResponse
}