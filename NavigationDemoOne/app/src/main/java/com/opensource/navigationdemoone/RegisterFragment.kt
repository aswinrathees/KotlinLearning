package com.opensource.navigationdemoone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.opensource.navigationdemoone.databinding.FragmentRegisterBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false)
        handleNavigation()
        return binding.root
    }

    private fun handleNavigation() {
        binding.registerButton.setOnClickListener {
            val email = binding.eTEmailAddress.text.toString()
            val password = binding.eTPassword.text.toString()

            when (email.isEmpty() || password.isEmpty()) {
                true -> Toast.makeText(activity, "Email or Password is empty", Toast.LENGTH_SHORT)
                    .show()

                false -> {
                    val bundle: Bundle = bundleOf(Pair("email", email), Pair("password", password))
                    it.findNavController().navigate(R.id.action_registerFragment_to_dataFragment, bundle)
                }
            }
        }
    }
}