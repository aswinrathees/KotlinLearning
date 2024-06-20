package com.opensource.samples.activities.intents

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.opensource.samples.MainActivity
import com.opensource.samples.R
import com.opensource.samples.databinding.ActivityCreateContactBinding

class CreateContactActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCreateContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_create_contact)

        binding.ivMoodHappy.setOnClickListener(this)
        binding.ivMoodBad.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (binding.etName.text.toString().isBlank() ||
            binding.etNumber.text.toString().isBlank() ||
            binding.etWebsite.text.toString().isBlank() ||
            binding.etLocation.text.toString().isBlank()) {
            Toast.makeText(this, "All fields are required !!", Toast.LENGTH_SHORT).show()
            return
        }

        val mood = if (p0 == binding.ivMoodHappy) "${R.drawable.ic_mood}" else "${R.drawable.ic_mood_bad}"

        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("name", binding.etName.text.toString().trim())
        intent.putExtra("number", binding.etNumber.text.toString().trim())
        intent.putExtra("profile", binding.etWebsite.text.toString().trim())
        intent.putExtra("location", binding.etLocation.text.toString().trim())
        intent.putExtra("mood", mood)

        setResult(RESULT_OK, intent)
        this.finish()
    }
}