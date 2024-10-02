package com.example.nectar.presentation.home.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.nectar.R
import com.example.nectar.databinding.FragmentSingInPageBinding


class FragmentSingInPage : Fragment() {
    private lateinit var binding: FragmentSingInPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSingInPageBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

    }

    private fun initView() {
        binding.btnSignIn.setOnClickListener {
            findNavController().navigate(R.id.action_singInPage_to_fragmentHomeScreen)
        }
    }

}