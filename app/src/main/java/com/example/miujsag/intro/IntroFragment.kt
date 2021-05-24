package com.example.miujsag.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.example.miujsag.R


class IntroFragment : Fragment() {
    private lateinit var userButton: Button
    private lateinit var editorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.apply {
           userButton = findViewById(R.id.olvaso)
           editorButton = findViewById(R.id.szerkeszto)
        }

        userButton.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_nav_current)
        }
        editorButton.setOnClickListener {
            findNavController().navigate(R.id.action_introFragment_to_loginFragment)
        }
    }
}