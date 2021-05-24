package com.example.miujsag.intro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.miujsag.R


class IntroFragment : Fragment(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_intro, container, false)
        val btnOlvaso: Button = view.findViewById(R.id.olvaso)
        val btnSzerkeszto:Button = view.findViewById(R.id.szerkeszto)
        btnOlvaso.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.olvaso->{

            }
            else->{

            }
        }
    }
}