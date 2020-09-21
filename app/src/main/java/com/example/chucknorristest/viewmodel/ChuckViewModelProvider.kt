package com.example.chucknorristest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.chucknorristest.model.RepositoryNorris

class ChuckViewModelProvider(
    val repositoryNorris: RepositoryNorris)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ChuckViewModel(repositoryNorris) as T
    }
}