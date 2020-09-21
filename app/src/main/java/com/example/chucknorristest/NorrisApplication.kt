package com.example.chucknorristest

import android.app.Application
import com.example.chucknorristest.di.component.ChuckComponent
import com.example.chucknorristest.di.component.DaggerChuckComponent
import com.example.chucknorristest.di.module.ApplicationModule
import com.example.chucknorristest.di.module.NetworkModule
import com.example.chucknorristest.di.module.RepositoryNorrisModule
import com.example.chucknorristest.di.module.VMProviderModule

class NorrisApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        chuckComponent = DaggerChuckComponent.builder()
            .vMProviderModule(VMProviderModule())
            .repositoryNorrisModule(RepositoryNorrisModule())
            .networkModule(NetworkModule())
            .applicationModule(ApplicationModule(applicationContext))
            .build()
    }

    companion object{
        private lateinit var chuckComponent:
                ChuckComponent

        fun getComponent(): ChuckComponent{
            return chuckComponent
        }
    }
}