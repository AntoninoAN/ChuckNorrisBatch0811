package com.example.chucknorristest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chucknorristest.R
import kotlinx.android.synthetic.main.common_joke_text.*

class SingleJoke: Fragment() {
    companion object{
        private val EXTRA_JOKE: String= "SingleJoke_EXTRA"

        fun newInstance(jokePhrace: String): SingleJoke{
            val fragment = SingleJoke()
            fragment.arguments = Bundle().apply {
                putString(EXTRA_JOKE, jokePhrace)
            }
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.single_joke_layout, container, true)
        tv_item_joke.text = arguments?.getString(EXTRA_JOKE)?: "The jokes on you Batman!"
        return view
    }
}