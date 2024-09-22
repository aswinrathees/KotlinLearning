package com.opensource.armcontacts

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.backendless.Backendless
import com.backendless.BackendlessUser
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.opensource.armcontacts.databinding.ActivityRegisterBinding
import com.opensource.armcontacts.utils.BaseActivity
import com.opensource.armcontacts.utils.Person

class RegisterActivity : BaseActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        initViews()
    }

    private fun initViews() {
        binding.btnRegisterUser.setOnClickListener {
            val fName = binding.etRegisterFName.text.toString()
            val lName = binding.etRegisterLName.text.toString()
            val email = binding.etRegisterEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()
            val confirmPassword = binding.etLoginRePassword.text.toString()

            if (fName.isNotEmpty() && lName.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty()) {
                if (binding.etLoginPassword.text.toString() == binding.etLoginRePassword.text.toString()) {
                    val person = Person(
                        firstName = binding.etRegisterFName.text.toString(),
                        lastName = binding.etRegisterLName.text.toString(),
                        email = binding.etRegisterEmail.text.toString(),
                        password = binding.etLoginPassword.text.toString()
                    )

                    val backendlessUser = BackendlessUser()
                    backendlessUser.email = person.email
                    backendlessUser.password = person.password
                    backendlessUser.setProperty("name", person.firstName)
                    backendlessUser.setProperty("firstName", person.firstName)
                    backendlessUser.setProperty("lastName", person.lastName)

                    Backendless.UserService.register(backendlessUser, object: AsyncCallback<BackendlessUser> {
                        override fun handleResponse(response: BackendlessUser?) {
                            Toast.makeText(baseContext, "Successfully registered for: ${response?.email}", Toast.LENGTH_SHORT).show()
                            finish()
                        }

                        override fun handleFault(fault: BackendlessFault?) {
                            Toast.makeText(baseContext, "Error: ${fault?.message}", Toast.LENGTH_SHORT).show()
                        }

                    })
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            }
        }
    }
}