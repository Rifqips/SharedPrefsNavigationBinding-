package com.rifqipadisiliwangi.cobabinding

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.rifqipadisiliwangi.cobabinding.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val appContext = requireContext().applicationContext
        sharedPrefs = appContext.getSharedPreferences("USERNAME", Context.MODE_PRIVATE)

        binding.tvUsername.text = sharedPrefs.getString("username","")

        btnLogout.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }
    }
}