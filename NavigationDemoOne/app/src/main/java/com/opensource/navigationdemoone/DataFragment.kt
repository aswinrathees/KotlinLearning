package com.opensource.navigationdemoone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.opensource.navigationdemoone.databinding.FragmentDataBinding

/**
 * A simple [Fragment] subclass.
 * Use the [DataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataFragment : Fragment() {

    private lateinit var binding: FragmentDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data, container, false)
        handleData()
        return binding.root
    }

    private fun handleData() {
        val email = arguments?.getString("email", "")
        email?.let {
            binding.tvUserWelcome.text = "Welcome $email"
        }
    }
}