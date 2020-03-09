package com.example.bottomnavigationexample.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bottomnavigationexample.R
import kotlinx.android.synthetic.main.fragment_notifications.view.*

class NotificationsFragment : Fragment() {

    // Create an instance of our viewmodel
    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // ViewModelProviders associates our viewmodel file to an instance of this
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)

        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)

        // Observe the data from our viewmodel
        notificationsViewModel.text.observe(this, Observer {
            // Set the text, coming from viewmodel
            // it refers to data. Alternatively, you can use: notificationsViewModel.text.value
            root.text_notifications.text = it
        })
        return root
    }
}