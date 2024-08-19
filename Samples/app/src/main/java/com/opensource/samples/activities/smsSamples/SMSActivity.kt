package com.opensource.samples.activities.smsSamples

import android.app.Activity
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.opensource.samples.R
import com.opensource.samples.databinding.ActivitySmsBinding

class SMSActivity : AppCompatActivity() {

    lateinit var binding: ActivitySmsBinding
    lateinit var sentPI: PendingIntent
    lateinit var deliveredPI: PendingIntent
    lateinit var smsSendReceiver: BroadcastReceiver
    lateinit var smsDeliveredReceiver: BroadcastReceiver

    val SMS_SENT = "SMS_SENT"
    val SMS_DELIVERED = "SMS_DELIVERED"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_sms)

        sentPI = PendingIntent.getBroadcast(this, 0, Intent(SMS_SENT), PendingIntent.FLAG_IMMUTABLE)
        deliveredPI = PendingIntent.getBroadcast(this, 0, Intent(SMS_DELIVERED), PendingIntent.FLAG_IMMUTABLE)

        initView()
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onResume() {
        super.onResume()

         smsSendReceiver =  object : BroadcastReceiver() {
             override fun onReceive(context: Context?, intent: Intent?) {

                 when (resultCode) {
                  Activity.RESULT_OK -> {
                      Toast.makeText(this@SMSActivity, "SMS sent", Toast.LENGTH_SHORT).show()
                  }
                  SmsManager.RESULT_ERROR_GENERIC_FAILURE -> {
                      Toast.makeText(this@SMSActivity, "Generic failure", Toast.LENGTH_SHORT).show()
                  }
                  SmsManager.RESULT_ERROR_NO_SERVICE -> {
                      Toast.makeText(this@SMSActivity, "No service", Toast.LENGTH_SHORT).show()
                  }
                  SmsManager.RESULT_ERROR_NULL_PDU -> {
                      Toast.makeText(this@SMSActivity, "Null PDU", Toast.LENGTH_SHORT).show()
                  }
                  SmsManager.RESULT_ERROR_RADIO_OFF -> {
                      Toast.makeText(this@SMSActivity, "Radio off", Toast.LENGTH_SHORT).show()
                  }
                 }
             }
         }
        
        smsDeliveredReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        Toast.makeText(this@SMSActivity, "SMS delivered", Toast.LENGTH_SHORT).show()
                    }

                    Activity.RESULT_CANCELED -> {
                        Toast.makeText(this@SMSActivity, "SMS not delivered", Toast.LENGTH_SHORT).show()
                    }

                    Activity.RESULT_FIRST_USER -> {
                        Toast.makeText(this@SMSActivity, "User specific error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        registerReceiver(smsSendReceiver, IntentFilter(SMS_SENT), RECEIVER_NOT_EXPORTED)
        registerReceiver(smsDeliveredReceiver, IntentFilter(SMS_DELIVERED), RECEIVER_NOT_EXPORTED)

    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(smsSendReceiver)
        unregisterReceiver(smsDeliveredReceiver)
    }

    private fun initView() {
        binding.btnSendSms.setOnClickListener {

            when (ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)) {
                PackageManager.PERMISSION_GRANTED -> {
                    val smsManager = SmsManager.getDefault()
                    val message = binding.etMessage.text.toString()
                    val phone = binding.etMobileNumber.text.toString()
                    smsManager.sendTextMessage(phone, null, message, sentPI, deliveredPI)
                }
                PackageManager.PERMISSION_DENIED -> {
                    requestPermissions(arrayOf(android.Manifest.permission.SEND_SMS), 100)
                }
            }
        }
    }
}