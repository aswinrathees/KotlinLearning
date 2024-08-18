package com.opensource.samples.activities.permissions

import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.opensource.samples.R
import com.opensource.samples.databinding.ActivityPermissionsBinding

class PermissionsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPermissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_permissions)

        initViews()
    }

    private fun initViews() {
        binding.btnPermissions.setOnClickListener {
            when (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.WRITE_CONTACTS
            )) {
                PackageManager.PERMISSION_GRANTED -> {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_LONG).show()
                }

                PackageManager.PERMISSION_DENIED -> {
                    requestPermissions(arrayOf(android.Manifest.permission.WRITE_CONTACTS), 1)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults[0] == 1) {
            Toast.makeText(this, "Thank you for granting permission", Toast.LENGTH_LONG).show()
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_CONTACTS)) {
                val alertDialog = AlertDialog.Builder(this)
                alertDialog.setMessage("This permission is important to save a contact")
                    .setTitle("Important")
                    .setPositiveButton("OK") { _, _ ->
                        run {
                            requestPermissions(arrayOf(android.Manifest.permission.WRITE_CONTACTS), 1)
                        }
                    }
                    .setNegativeButton("No Thanks") { _, _ ->
                        run {
                            Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show()
                        }
                    }

                alertDialog.show()
            } else {
                Toast.makeText(this, "Will never show again", Toast.LENGTH_LONG).show()
            }
        }
    }
}