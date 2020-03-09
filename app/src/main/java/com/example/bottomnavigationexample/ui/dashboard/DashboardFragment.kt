package com.example.bottomnavigationexample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigationexample.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    // Create an instance of our viewmodel
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ViewModelProviders associates our viewmodel file to an instance of this
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Observe the data from our viewmodel
        dashboardViewModel.text.observe(this, Observer {
            // Set the text, coming from viewmodel
            // it refers to data. Alternatively, you can use: dashboardViewModel.text.value
            text_dashboard.text = it
        })
        return root
    }
}