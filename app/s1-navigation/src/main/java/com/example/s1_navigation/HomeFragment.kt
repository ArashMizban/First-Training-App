package com.example.s1_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.s1_navigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var HomeBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        HomeBinding = FragmentHomeBinding.inflate(inflater , container , false)
        return HomeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        HomeBinding.apply {
            sendBtn.setOnClickListener {
                findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
            }

        }
    }
}