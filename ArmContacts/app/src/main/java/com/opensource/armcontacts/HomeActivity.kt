package com.opensource.armcontacts

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.opensource.armcontacts.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var dataBindingUtil: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_home)
        initViews()
    }

    private fun initViews() {
        dataBindingUtil.btnListContacts.setOnClickListener {
            startActivity(Intent(this, ContactListActivity::class.java))
        }

        dataBindingUtil.btnCreateContact.setOnClickListener {
            startActivity(Intent(this, NewContactActivity::class.java))
        }
    }
}