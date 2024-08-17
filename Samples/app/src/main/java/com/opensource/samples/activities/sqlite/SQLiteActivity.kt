package com.opensource.samples.activities.sqlite

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.opensource.samples.R
import com.opensource.samples.activities.sqlite.helpers.Contacts
import com.opensource.samples.databinding.ActivitySqliteBinding

class SQLiteActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySqliteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sqlite)
        initViews()
    }

    private fun initViews() {
        binding.btnSqliteSubmitDetails.setOnClickListener {
            val name = binding.etSqliteName.text.toString().trim()
            val number = binding.etSqliteMobileNumber.text.toString().trim()

            try {
                val contacts = Contacts(this)
                contacts.open()
                contacts.addEntry(name, number)
                contacts.close()

                Toast.makeText(this, "Details Added", Toast.LENGTH_SHORT).show()

                binding.etSqliteName.setText("")
                binding.etSqliteMobileNumber.setText("")

            } catch (t: Throwable) {
                Toast.makeText(this, "Error In Adding Details", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSqliteShowDetails.setOnClickListener {
            startActivity(Intent(this, ViewSQLiteDataActivity::class.java))
        }

        binding.btnSqliteUpdateDetails.setOnClickListener {
            try {
                val contacts = Contacts(this)
                contacts.open()
                contacts.updateEntry("1","Rathees","9846460653")
                contacts.close()

                Toast.makeText(this, "Details Updated", Toast.LENGTH_SHORT).show()
            } catch (t: Throwable) {
                Toast.makeText(this, "Error In Updating Details", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSqliteDeleteDetails.setOnClickListener {
            try {
                val contacts = Contacts(this)
                contacts.open()
                contacts.deleteEntry("1")
                contacts.close()

                Toast.makeText(this, "Details Deleted", Toast.LENGTH_SHORT).show()
            } catch (t: Throwable) {
                Toast.makeText(this, "Error In Deleting Details", Toast.LENGTH_SHORT).show()
            }
        }
    }
}