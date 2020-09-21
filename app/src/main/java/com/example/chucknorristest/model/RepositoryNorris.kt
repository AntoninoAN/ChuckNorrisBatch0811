package com.example.chucknorristest.model

/**
 * Class that defines getting data from Cache
 * in a offline Mode or getting data from
 * Network call
 */
class RepositoryNorris(val network: Network) {

    suspend fun getRandomJoke(): JokesResponse{
        //if(checkNetworkConnection())
            return network.getRandomJoke()
    }
    suspend fun getNamedJoke(
        firstName: String,
        lastName: String
    ): JokesResponse{
        return network.getRandomJokeWithName(firstName,
            lastName)
    }

    suspend fun getListOfJokes(): JokeListResponse{
        return network.getRandomListJoke()
    }

    /**
     * @return true if Devices is Online
     */
    private fun checkNetworkConnection():Boolean{
        return true
    }
}