package com.opensource.navigationdemotwo

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.opensource.navigationdemotwo.databinding.FragmentNameBinding

/**
 * A simple [Fragment] subclass.
 * Use the [NameFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NameFragment : Fragment() {

    private lateinit var binding: FragmentNameBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_name, container, false)
        binding.submit.setOnClickListener {
            if (TextUtils.isEmpty(binding.editTextPersonName.text.toString()))
                Toast.makeText(activity, "Empty Name", Toast.LENGTH_SHORT).show()
            else {
                val bundle: Bundle =
                    bundleOf("user_input_name" to binding.editTextPersonName.text.toString())
                it.findNavController().navigate(R.id.action_nameFragment_to_emailFragment, bundle)
            }
        }
        return binding.root
    }
}