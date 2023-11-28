package com.example.s1_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.s1_navigation.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private lateinit var DetailBinding: FragmentDetailBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        DetailBinding = FragmentDetailBinding.inflate(inflater , container , false)
        return DetailBinding.root
    }
}
