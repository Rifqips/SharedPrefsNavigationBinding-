package com.rifqipadisiliwangi.cobabinding

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.rifqipadisiliwangi.cobabinding.databinding.FragmentSplashBinding

class SplashFragment : Fragment() {

    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(inflater,container,false)

        Handler(Looper.myLooper()!!).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        },3000)

        return binding.root
    }
}