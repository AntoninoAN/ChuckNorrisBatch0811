package com.example.chucknorristest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.chucknorristest.model.JokesResponse
import com.example.chucknorristest.view.NamedFragment
import com.example.chucknorristest.view.SingleJoke
import com.example.chucknorristest.viewmodel.ChuckViewModel
import com.example.chucknorristest.viewmodel.ChuckViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var chuckViewModelProvider: ChuckViewModelProvider

    lateinit var chuckViewModel: ChuckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NorrisApplication.getComponent().inject(this)
        chuckViewModel = chuckViewModelProvider
            .create(ChuckViewModel::class.java)

        btn_first_case.setOnClickListener { getSingleJoke() }
        btn_second_case.setOnClickListener { getNamedJoke() }
        btn_third_case.setOnClickListener { getEndlessJoke() }

        chuckViewModel.mutableLivedataSingleJoke.observe(this,
        Observer {
            showSingleJokeFragment(it)
        })
    }

    private fun showSingleJokeFragment(response: JokesResponse) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container,
            SingleJoke.newInstance(response.value.joke))
            .commit()
    }

    private fun getEndlessJoke() {
        chuckViewModel.getEndlessJoke()
    }

    private fun getNamedJoke() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, NamedFragment.newInstance())
            .addToBackStack(null)
            .commit()
    }

    private fun getSingleJoke() {
        chuckViewModel.getSingleJoke()
    }
}