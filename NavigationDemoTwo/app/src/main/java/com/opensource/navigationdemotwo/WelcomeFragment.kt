package com.opensource.navigationdemotwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.opensource.navigationdemotwo.databinding.FragmentWelcomeBinding

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)
        binding.welcomeTextView2.setText(arguments?.getString("user_input_email") ?: "")
        binding.welcomeTextView.setText(arguments?.getString("name") ?: "")
        binding.button.setOnClickListener {
            it.findNavController().navigate(R.id.action_welcomeFragment_to_termsFragment)
        }
        return binding.root
    }
}