package com.example.miujsag.ui.members

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.miujsag.R

class MembersFragment : Fragment() {

    private lateinit var membersViewModel: MembersViewModel
    private lateinit var cikkButton: Button
    private lateinit var fb: TextView

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        membersViewModel =
                ViewModelProvider(this).get(MembersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_members, container, false)
        val textView: TextView = root.findViewById(R.id.text_members)
        membersViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cikkButton = view.findViewById(R.id.submit_cikk)
        fb = view.findViewById(R.id.fb_link)

        fb.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(fb.text.toString()))
            startActivity(browserIntent)
        }

        cikkButton.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://script.google.com/macros/s/AKfycbwM9SED9nqoeBZrDdKQ8DlFvpwtS682jjPDXmsL4e0-fEYqtKtK/exec?fbclid=IwAR0iXO1eOK5bMPbhQfzb1Hcqqaf0Lt29wulJhxD8Q9vCEnwj_tLLj-T-GZs"))
            startActivity(browserIntent)
        }

        super.onViewCreated(view, savedInstanceState)
    }
}