package com.example.chucknorristest.viewmodel

import androidx.lifecycle.*
import com.example.chucknorristest.model.JokesResponse
import com.example.chucknorristest.model.RepositoryNorris
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.launch

class ChuckViewModel(val repositoryNorris: RepositoryNorris) : ViewModel() {

    val liveDataSingleJoke: LiveData<JokesResponse> =
        liveData{
            emit(repositoryNorris.getRandomJoke())
        }

    val mutableLivedataSingleJoke = MutableLiveData<JokesResponse>()

    fun getSingleJokeLiveData(): LiveData<JokesResponse>{
        return mutableLivedataSingleJoke
    }

    fun getSingleJoke() {
        viewModelScope.launch {
            mutableLivedataSingleJoke.value=
                repositoryNorris.getRandomJoke()
        }
    }

    fun getNamedJoke(firstName: String, lastName: String) {
        viewModelScope.launch { repositoryNorris.getNamedJoke(firstName, lastName) }
    }

    fun getEndlessJoke() {
        viewModelScope.launch {
            repositoryNorris.getListOfJokes()
        }
    }
}