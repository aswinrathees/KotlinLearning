package com.opensource.armcontacts

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.opensource.armcontacts.databinding.ActivityContactInfoBinding
import com.opensource.armcontacts.utils.ApplicationUser

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

        }
    }
}