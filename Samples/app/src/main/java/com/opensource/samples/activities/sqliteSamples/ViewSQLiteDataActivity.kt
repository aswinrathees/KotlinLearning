package com.opensource.samples.activities.sqliteSamples

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.opensource.samples.R
import com.opensource.samples.activities.sqliteSamples.helpers.Contacts
import com.opensource.samples.databinding.ActivityViewSqliteDataBinding

class ViewSQLiteDataActivity : AppCompatActivity() {

    lateinit var bindingUtil: ActivityViewSqliteDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingUtil = DataBindingUtil.setContentView(this, R.layout.activity_view_sqlite_data)
        loadData()
    }

    private fun loadData() {
        try {
            val contacts = Contacts(this)
            contacts.open()
            bindingUtil.tvViewSqliteData.text = contacts.getData()
            contacts.close()
        } catch (t: Throwable) {
            Toast.makeText(this, "Error: " + t.message, Toast.LENGTH_LONG).show()
        }
    }
}