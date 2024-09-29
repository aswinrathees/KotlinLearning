package com.opensource.armcontacts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.opensource.armcontacts.databinding.ActivityContactInfoBinding
import com.opensource.armcontacts.utils.ApplicationUser
import com.opensource.armcontacts.utils.Contact

class ContactInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_info)
        initViews()
    }

    private fun initViews() {
        binding.etCiName.visibility = View.GONE
        binding.etCiPhone.visibility = View.GONE
        binding.etCiEmail.visibility = View.GONE

        val index = intent.getIntExtra("index", 0)
        binding.tvCiName.text = ApplicationUser.contactList[index].name
        binding.tvCiPhone.text = ApplicationUser.contactList[index].phone

        binding.etCiName.setText(ApplicationUser.contactList[index].name)
        binding.etCiPhone.setText(ApplicationUser.contactList[index].phone)
        binding.etCiEmail.setText(ApplicationUser.contactList[index].email)

        binding.ivPhoneCall.setOnClickListener {
            val uri = "tel:" + ApplicationUser.contactList[index].phone
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse(uri)
            startActivity(intent)
        }

        binding.ivSendMail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, ApplicationUser.contactList[index].email)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hello")
            startActivity(Intent.createChooser(intent, "Send Email : ${ApplicationUser.contactList[index].email}"))
        }

        binding.ivEdit.setOnClickListener {
            binding.etCiName.visibility = View.VISIBLE
            binding.etCiPhone.visibility = View.VISIBLE
            binding.etCiEmail.visibility = View.VISIBLE
        }

        binding.ivDelete.setOnClickListener {
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Delete Contact")
            alertDialog.setMessage("Are you sure you want to delete this contact?")
            alertDialog.setPositiveButton("Yes") { _, _ ->
                Backendless.Persistence.of(Contact::class.java).remove(
                    ApplicationUser.contactList[index],
                    object : AsyncCallback<Long> {
                        override fun handleResponse(response: Long?) {
                            Toast.makeText(baseContext, "Successfully deleted", Toast.LENGTH_SHORT).show()
                            ApplicationUser.contactList.removeAt(index)
                            finish()
                        }

                        override fun handleFault(fault: BackendlessFault?) {
                            Toast.makeText(baseContext, "Error : ${fault?.message}", Toast.LENGTH_SHORT).show()
                        }
                    })
            }

            alertDialog.setNegativeButton("No") { _, _ -> }
            alertDialog.show()
        }

        binding.btnEditCi.setOnClickListener {

            val name = binding.etCiName.text.toString()
            val mail = binding.etCiEmail.text.toString()
            val phone = binding.etCiPhone.text.toString()

            if (name.isNotEmpty() && mail.isNotEmpty() && phone.isNotEmpty()) {
                ApplicationUser.contactList[index].name = name
                ApplicationUser.contactList[index].email = mail
                ApplicationUser.contactList[index].phone = phone

                Backendless.Persistence.save(ApplicationUser.contactList[index], object : AsyncCallback<Contact>{
                    override fun handleResponse(response: Contact?) {
                        Toast.makeText(baseContext, "Successfully Updated", Toast.LENGTH_SHORT).show()

                        binding.etCiName.visibility = View.GONE
                        binding.etCiPhone.visibility = View.GONE
                        binding.etCiEmail.visibility = View.GONE

                        binding.tvCiName.text = ApplicationUser.contactList[index].name
                        binding.tvCiPhone.text = ApplicationUser.contactList[index].phone
                    }

                    override fun handleFault(fault: BackendlessFault?) {
                        Toast.makeText(baseContext, "Error : ${fault?.message}", Toast.LENGTH_SHORT).show()
                    }

                })
            } else {
                Toast.makeText(this, "Fields are empty", Toast.LENGTH_SHORT).show()
            }
        }
    }
}