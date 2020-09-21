package com.example.chucknorristest.model

class Network(val api: ChuckNorrisAPI) {

    suspend fun getRandomJoke(): JokesResponse{
        return api.getMeRandomJoke()
    }
    suspend fun getRandomJokeWithName(
        firstName: String,
        lastName: String
    ): JokesResponse{
        return api.getMeRandomJokeWithName(firstName,
        lastName)
    }
    suspend fun getRandomListJoke(): JokeListResponse{
        return api.getMeRandomEndlessJoke()
    }
}