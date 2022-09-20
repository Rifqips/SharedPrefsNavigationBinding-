package com.rifqipadisiliwangi.cobabinding

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rifqipadisiliwangi.cobabinding.databinding.FragmentRegisterBinding
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*


class RegisterFragment : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContext = requireContext().applicationContext
        sharedPrefs = appContext.getSharedPreferences("USERNAME", Context.MODE_PRIVATE)

        btnSignup.setOnClickListener {
            saveData()
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    fun saveData(){
        val user = binding.etUsername.text.toString()
        val fullName = binding.etFullname.text.toString()
        val password = binding.etPassword.text.toString()
        val confirm = binding.etConfirm.text.toString()
        var addUser = sharedPrefs.edit()
        addUser.putString("username", user)
        addUser.putString("usernameName", fullName)
        addUser.putString("password", password)
        addUser.putString("confirm", confirm)
        addUser.apply()
    }
}