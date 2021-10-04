package com.example.kodecamptask4

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kodecamptask4.databinding.FragmentFirstBinding


class FirstFragment: Fragment(R.layout.fragment_first) {

    private var fragment1Binding : FragmentFirstBinding? = null
    private lateinit var communicator: Communicator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentFirstBinding.inflate(inflater, container, false)
        fragment1Binding = binding

        communicator = activity as Communicator

        binding.btnNext.setOnClickListener {
            communicator.passData(binding.etName.text.toString(), binding.etPhone.text.toString(), binding.etCountry.text.toString())
        }
        return fragment1Binding!!.root
    }

    override fun onDestroyView() {
        fragment1Binding = null
        return super.onDestroyView()
    }
}