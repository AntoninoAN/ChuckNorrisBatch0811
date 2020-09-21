package com.example.chucknorristest.di.module

import com.example.chucknorristest.model.RepositoryNorris
import com.example.chucknorristest.viewmodel.ChuckViewModelProvider
import dagger.Module
import dagger.Provides

@Module
class VMProviderModule {
    @Provides
    fun provideVMProvider(repositoryNorris: RepositoryNorris)
        :ChuckViewModelProvider{
        return ChuckViewModelProvider(repositoryNorris)
    }
}