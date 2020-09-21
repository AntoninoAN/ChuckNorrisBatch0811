package com.example.chucknorristest.di.component

import com.example.chucknorristest.MainActivity
import com.example.chucknorristest.di.module.ApplicationModule
import com.example.chucknorristest.di.module.NetworkModule
import com.example.chucknorristest.di.module.RepositoryNorrisModule
import com.example.chucknorristest.di.module.VMProviderModule
import com.example.chucknorristest.view.NamedFragment
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class,
RepositoryNorrisModule::class, VMProviderModule::class,
ApplicationModule::class])
@Singleton
interface ChuckComponent {
    fun inject(mainActivity: MainActivity)
    fun fragmentInject(namedFragment: NamedFragment)
}