package com.opensource.samples.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.samples.R
import com.opensource.samples.activities.intents.CreateContactActivity
import com.opensource.samples.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityIntentBinding
    private val CREATE_CONTACT_REQUEST_CODE = 1
    private var name: String? = null
    private var number: String? = null
    private var profile: String? = null
    private var location: String? = null
    private var mood: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent)

        handleViews()
        handleOnClick()
    }

    private fun handleViews(visible: Int = View.GONE) {
        binding.ivMood.visibility = visible
        binding.ivPhone.visibility = visible
        binding.ivPhone.setOnClickListener(this)
        binding.ivWeb.visibility = visible
        binding.ivWeb.setOnClickListener(this)
        binding.ivLocation.visibility = visible
        binding.ivLocation.setOnClickListener(this)
    }

    private fun handleOnClick() {
        binding.btnCreateContact.setOnClickListener {
            navigateToActivity(CreateContactActivity::class.java)
        }
    }

    private fun navigateToActivity(clazz: Class<*>) {
        val intent = Intent(this, clazz)
        startActivityForResult(intent, CREATE_CONTACT_REQUEST_CODE)
        //resultLauncher.launch(intent) // Newer approach
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CREATE_CONTACT_REQUEST_CODE && resultCode == RESULT_OK) {
            handleIntents(data)
        }
    }

    private fun handleIntents(data: Intent?) {
        name = data?.getStringExtra("name")
        number = data?.getStringExtra("number")
        profile = data?.getStringExtra("profile")
        location = data?.getStringExtra("location")
        mood = data?.getStringExtra("mood")?.toInt()

        number?.let {
            binding.ivPhone.visibility  = View.VISIBLE
        }

        profile?.let {
            binding.ivWeb.visibility = View.VISIBLE
        }

        location?.let {
            binding.ivLocation.visibility = View.VISIBLE
        }

        mood?.let {
            binding.ivMood.visibility = View.VISIBLE
            binding.ivMood.setImageResource(mood as Int)
        }
    }

    override fun onClick(p0: View?) {
        when (p0) {
            binding.ivPhone -> {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number"))
                startActivity(intent)
            }

            binding.ivWeb -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://$profile"))
                startActivity(intent)
            }

            binding.ivLocation -> {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=$location"))
                startActivity(intent)
            }
        }
    }

    // Can also try BetterActivityResult.registerActivityForResult
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        // Handle result here
    }
}