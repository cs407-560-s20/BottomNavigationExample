package com.example.bottomnavigationexample.ui.settings

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import com.example.bottomnavigationexample.R
import kotlinx.android.synthetic.main.settings_fragment.view.*

class SettingsFragment : Fragment() {

    // Create an instance of our viewmodel
    private lateinit var settingsViewModel: SettingsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ViewModelProviders associates our viewmodel file to an instance of this
        settingsViewModel = ViewModelProviders.of(this).get(SettingsViewModel::class.java)

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.settings_fragment, container, false)

        // Observe the data from our viewmodel
        settingsViewModel.text.observe(this, Observer {
            // Set the text, coming from viewmodel
            // it refers to data. Alternatively, you can use: settingsViewModel.text.value
            root.text_settings.text = it
        })
        return root
    }
}