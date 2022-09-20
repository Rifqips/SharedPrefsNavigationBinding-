package com.rifqipadisiliwangi.cobabinding

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.rifqipadisiliwangi.cobabinding.databinding.FragmentLoginBinding
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContext = requireContext().applicationContext
        sharedPrefs = appContext.getSharedPreferences("USERNAME", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            trackingData(binding.etUsername.text.toString(), binding.etPassword.text.toString())
            findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
        }

        tvSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    fun trackingData(username : String, password : String ){
        if (binding.etUsername.text.length == 0 && binding.etPassword.text.length == 0){
            Toast.makeText(context,"Masukkan User Account",Toast.LENGTH_LONG).show()
        }else {
            if (sharedPrefs.getString("username","")== username && sharedPrefs.getString("password","") == password){
            }else{
                Toast.makeText(context,"Data anda salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}