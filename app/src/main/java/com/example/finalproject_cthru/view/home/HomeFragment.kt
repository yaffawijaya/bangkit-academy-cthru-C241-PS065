package com.example.finalproject_cthru.view.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.finalproject_cthru.R
import com.example.finalproject_cthru.databinding.FragmentHomeBinding
import com.example.finalproject_cthru.view.onboarding.OnboardingActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dashboardViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Use binding to access the button
        val button: Button = binding.onboardingButton
        button.setOnClickListener {
            val intent = Intent(activity, OnboardingActivity::class.java)
            startActivity(intent)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
