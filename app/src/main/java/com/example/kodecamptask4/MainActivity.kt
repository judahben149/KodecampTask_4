package com.example.kodecamptask4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.kodecamptask4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Communicator {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment = FirstFragment()
        //val secondFragment = SecondFragment()

        loadFragment(firstFragment)

    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun passData(name: String, phone: String, country: String) {
        val bundle = Bundle()
        bundle.putString("name", name)
        bundle.putString("phone", phone)
        bundle.putString("country", country)
        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        //bundle.putString("phone", phonePass)
        //bundle.putString("country", countryPass)
        val transaction = this.supportFragmentManager.beginTransaction()
            transaction.replace(R.id.flFragment, secondFragment)
            transaction.addToBackStack(null)
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
            transaction.commit()
    }
}