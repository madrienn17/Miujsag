package com.example.miujsag.login_register

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.navigation.fragment.findNavController
import com.example.miujsag.MainActivity
import com.example.miujsag.R
import com.example.miujsag.data.DaoViewModel
import com.example.miujsag.models.User
import com.example.miujsag.utils.Constants

class RegisterFragment : Fragment() {

    private val daoViewModel: DaoViewModel by activityViewModels()
    private lateinit var user: User
    lateinit var users: List<User>
    lateinit var allUsers: LiveData<List<User>>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allUsers = daoViewModel.readAllUsers
        allUsers.observe(viewLifecycleOwner, { us ->
            users = us
        })

        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        /**
         * Initializing UI elements
         */
        val userName = view.findViewById<EditText>(R.id.user_name)
        val userAddress = view.findViewById<EditText>(R.id.user_adress)
        val userPassword = view.findViewById<EditText>(R.id.password)
        val userEmail = view.findViewById<EditText>(R.id.user_email)


        val signupButton = view.findViewById<Button>(R.id.finish_registration)

        /**
         * Listener to Sign Up button
         */
        signupButton.setOnClickListener {
            user = User(
                userName.text.toString(),
                userAddress.text.toString(),
                userEmail.text.toString(),
                userPassword.text.toString()
            )

            /**
             * If the registration was success it will add it to the DB and set the User Name
             */
            if (isRegistered(user)) {
                Toast.makeText(context, "You are a registered user ! Did you forgot your password?", Toast.LENGTH_LONG).show()
            } else {
                MainActivity.isLoggedIn = true
                Log.d("Successful sign up!", user.name)
                daoViewModel.addUserDB(user)
                setUser(user.name)
                findNavController().navigate(R.id.nav_current)
            }
        }
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun setUser(name: String) {
            Constants.USER_NAME = name
        }
    }

    /**
     * Check if the User was registered already
     * @param user User
     * @return Boolean
     */
    private fun isRegistered(user: User): Boolean {
        for (u in users) {
            if ((u.email == user.email) && (u.password == user.password)) {
                return true
            }
        }
        return false
    }
}