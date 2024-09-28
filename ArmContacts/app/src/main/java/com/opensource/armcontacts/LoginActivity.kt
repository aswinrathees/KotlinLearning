package com.opensource.armcontacts

import android.content.Intent
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
import com.backendless.persistence.local.UserIdStorageFactory
import com.opensource.armcontacts.databinding.ActivityLoginBinding
import com.opensource.armcontacts.utils.ApplicationUser
import com.opensource.armcontacts.utils.BaseActivity

class LoginActivity : BaseActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        initViews()
    }

    private fun initViews() {
        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.etLoginEmail.text.toString()
            val password = binding.etLoginPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show()
            } else {
                Backendless.UserService.login(
                    email,
                    password,
                    object : AsyncCallback<BackendlessUser> {
                        override fun handleResponse(response: BackendlessUser?) {
                            response?.let {
                                ApplicationUser.user = it
                            }
                            Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_SHORT)
                                .show()
                            navigateToActivity(HomeActivity::class.java)
                        }

                        override fun handleFault(fault: BackendlessFault?) {
                            Toast.makeText(
                                baseContext,
                                "Error: ${fault?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }, true)
            }
        }

        binding.tvForgotPassword.setOnClickListener {
            val email = binding.etLoginEmail.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error in resetting", Toast.LENGTH_SHORT).show()
                // Handling based on the Backendless platform
                /*Backendless.UserService.restorePassword(email, object : AsyncCallback<Void> {
                    override fun handleResponse(response: Void?) {
                        TODO("Not yet implemented")
                    }

                    override fun handleFault(fault: BackendlessFault?) {
                        TODO("Not yet implemented")
                    }
                })*/
            }
        }

        Backendless.UserService.isValidLogin(object: AsyncCallback<Boolean> {
            override fun handleResponse(response: Boolean?) {
                if (response == true) {
                    val userObjectId = UserIdStorageFactory.instance().storage.get()
                    Backendless.Data.of(BackendlessUser::class.java).findById(userObjectId, object: AsyncCallback<BackendlessUser> {
                        override fun handleResponse(response: BackendlessUser?) {
                            response?.let {
                                ApplicationUser.user = it
                            }
                            navigateToActivity(HomeActivity::class.java)
                        }

                        override fun handleFault(fault: BackendlessFault?) {
                            Toast.makeText(baseContext, "Error : ${fault?.message}", Toast.LENGTH_SHORT).show()
                        }

                    })
                }
            }

            override fun handleFault(fault: BackendlessFault?) {
                Toast.makeText(baseContext, "Error : ${fault?.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun navigateToActivity(clazz: Class<*>) {
        val intent = Intent(baseContext, clazz)
        startActivity(intent)
        finish()
    }
}