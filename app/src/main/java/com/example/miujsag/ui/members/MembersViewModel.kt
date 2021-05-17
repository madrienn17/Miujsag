package com.example.miujsag.ui.members

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MembersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Légy te is a csapatunk része!"
    }
    val text: LiveData<String> = _text
}