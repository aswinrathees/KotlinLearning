package com.opensource.armcontacts

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.opensource.armcontacts.databinding.ActivityNewContactBinding
import com.opensource.armcontacts.utils.ApplicationUser
import com.opensource.armcontacts.utils.Contact

class NewContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_new_contact)

        initView()
    }

    private fun initView() {
        binding.btnCreateNewContact.setOnClickListener {
            val name = binding.etContactName.text.toString()
            val phone = binding.etContactNumber.text.toString()
            val email = binding.etContactEmail.text.toString()

            if (name.isNotEmpty() && phone.isNotEmpty() && email.isNotEmpty()) {
                val contact = Contact(name, phone, email, ApplicationUser.user.email ?: "")

                Backendless.Persistence.save(contact, object: AsyncCallback<Contact> {
                    override fun handleResponse(response: Contact?) {
                        Toast.makeText(baseContext, "Contact saved", Toast.LENGTH_SHORT).show()

                        binding.etContactName.text.clear()
                        binding.etContactNumber.text.clear()
                        binding.etContactEmail.text.clear()
                    }

                    override fun handleFault(fault: BackendlessFault?) {
                        Toast.makeText(baseContext, "Error in saving contact : ${fault?.message}", Toast.LENGTH_SHORT).show()
                    }

                })
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}