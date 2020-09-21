package com.example.chucknorristest.di.module

import com.example.chucknorristest.model.Network
import com.example.chucknorristest.model.RepositoryNorris
import dagger.Module
import dagger.Provides

@Module
class RepositoryNorrisModule {
    @Provides
    fun provideRepository(network: Network): RepositoryNorris{
        return RepositoryNorris(network)
    }
}