package com.opensource.navigationdemoone

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.opensource.navigationdemoone.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.button.setOnClickListener {
            if (TextUtils.isEmpty(binding.editTextPersonName.text.toString()))
                Toast.makeText(activity, "EditText is empty", Toast.LENGTH_SHORT).show()
            else {
                val bundle: Bundle =
                    bundleOf("user_input" to binding.editTextPersonName.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            }
        }
        return binding.root
    }
}