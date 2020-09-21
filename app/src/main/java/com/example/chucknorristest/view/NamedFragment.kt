package com.example.chucknorristest.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chucknorristest.NorrisApplication
import com.example.chucknorristest.R
import com.example.chucknorristest.viewmodel.ChuckViewModel
import com.example.chucknorristest.viewmodel.ChuckViewModelProvider
import kotlinx.android.synthetic.main.named_joke_layout.*
import kotlinx.android.synthetic.main.named_joke_layout.view.*
import javax.inject.Inject

class NamedFragment: Fragment() {

    @Inject
    lateinit var viewModelProvider: ChuckViewModelProvider
    lateinit var chuckViewModel: ChuckViewModel
    companion object{
        fun newInstance(): NamedFragment{
            val fragment= NamedFragment()
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NorrisApplication.getComponent().fragmentInject(this)
        chuckViewModel = viewModelProvider.create(ChuckViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=
            inflater.inflate(R.layout.named_joke_layout,
                container,
                true)
        view.btn_get_named_joke.setOnClickListener {
            sendNamedJoke()
        }
        return view
    }

    private fun sendNamedJoke() {
        chuckViewModel.getNamedJoke(
            et_first_name.text.toString(),
            et_last_name.text.toString()
        )
    }
}