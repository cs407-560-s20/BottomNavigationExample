package com.example.bottomnavigationexample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigationexample.R
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    // Create an instance of our viewmodel
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ViewModelProviders associates our viewmodel file to an instance of this
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        // Observe the data from our viewmodel
        homeViewModel.text.observe(this, Observer {
            // Set the text, coming from viewmodel
            // it refers to data. Alternatively, you can use: homeViewModel.text.value
            root.text_home.text = it
        })
        return root
    }
}