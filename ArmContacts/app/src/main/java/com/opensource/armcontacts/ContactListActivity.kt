package com.opensource.armcontacts

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.backendless.Backendless
import com.backendless.async.callback.AsyncCallback
import com.backendless.exceptions.BackendlessFault
import com.backendless.persistence.DataQueryBuilder
import com.opensource.armcontacts.R
import com.opensource.armcontacts.databinding.ActivityContactListBinding
import com.opensource.armcontacts.utils.ApplicationUser
import com.opensource.armcontacts.utils.Contact
import com.opensource.armcontacts.utils.ContactsAdapter
import com.opensource.armcontacts.utils.ItemSelected

class ContactListActivity : AppCompatActivity(), ItemSelected {

    private lateinit var binding: ActivityContactListBinding
    private lateinit var contactList: List<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_contact_list)
        fetchData()
    }

    private fun fetchData() {
        val clause = "appUserEmail= '${ApplicationUser.user.email}'"

        val queryBuilder = DataQueryBuilder.create()
        queryBuilder.whereClause = clause
        //queryBuilder.setGroupBy("name")

        binding.rvContacts.layoutManager = LinearLayoutManager(this@ContactListActivity)

        Backendless.Persistence.of(Contact::class.java).find(queryBuilder, object : AsyncCallback<List<Contact>> {
            override fun handleResponse(response: List<Contact>?) {
                response?.let {
                    contactList = it
                    ApplicationUser.contactList = it
                    val adapter = ContactsAdapter(this@ContactListActivity.contactList)
                    binding.rvContacts.adapter = adapter
                }
            }

            override fun handleFault(fault: BackendlessFault?) {
                Toast.makeText(baseContext, "Error: " + fault?.message, Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onItemSelected(index: Int) {
        val intent = Intent(this, ContactInfoActivity::class.java)
        intent.putExtra("contactId", index)
        startActivity(intent)
    }
}