package com.example.kodecamptask4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kodecamptask4.databinding.FragmentSecondBinding


class SecondFragment: Fragment(R.layout.fragment_second) {

    private var nameGotten: String? = ""
    private var phoneGotten: String? = ""
    private var countryGotten: String? = ""
    private var fragment2Binding : FragmentSecondBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentSecondBinding.inflate(inflater, container, false)
        fragment2Binding = binding
        nameGotten = arguments?.getString("name")
        phoneGotten = arguments?.getString("phone")
        countryGotten = arguments?.getString("country")
        binding.tvDisplayText.text = "Your name is ${nameGotten}. \nYou are from ${countryGotten}. \nYour phone number is ${phoneGotten}"

        return fragment2Binding!!.root
    }

    override fun onDestroyView() {
        fragment2Binding = null
        return super.onDestroyView()
    }
}