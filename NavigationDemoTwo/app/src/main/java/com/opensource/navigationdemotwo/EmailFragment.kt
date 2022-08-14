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
import com.opensource.navigationdemotwo.databinding.FragmentEmailBinding

/**
 * A simple [Fragment] subclass.
 * Use the [EmailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EmailFragment : Fragment() {
    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_email, container, false)
        val name: String = arguments?.getString("user_input_name") ?: "No name"
        binding.nameTextView.setText("Hi, " + name)
        binding.submit.setOnClickListener {
            if (TextUtils.isEmpty(binding.editTextEmailAddress.text.toString())) {
                Toast.makeText(activity, "Empty Email", Toast.LENGTH_SHORT).show()
            } else {
                val bundle: Bundle =
                    bundleOf(
                        "user_input_email" to binding.editTextEmailAddress.text.toString(),
                        "name" to name
                    )
                it.findNavController()
                    .navigate(R.id.action_emailFragment_to_welcomeFragment, bundle)
            }
        }
        return binding.root
    }
}