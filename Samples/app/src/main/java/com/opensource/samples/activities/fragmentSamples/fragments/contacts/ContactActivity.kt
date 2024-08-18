package com.opensource.samples.activities.fragmentSamples.fragments.contacts

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.opensource.samples.R
import com.opensource.samples.activities.fragmentSamples.fragments.contacts.helpers.Person
import com.opensource.samples.activities.fragmentSamples.fragments.contacts.helpers.PersonClicked

class ContactActivity : AppCompatActivity(), PersonClicked {

    private var tvName:TextView? = null
    private var tvPhone:TextView? = null
    private val contacts = ArrayList<Person>()
    private var btnAddContact: Button? = null
    private lateinit var listFragment: ContactListFragment
    private lateinit var etName: EditText
    private lateinit var etPhone: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact)

        listFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as ContactListFragment
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            tvName = findViewById(R.id.contactName)
            tvPhone = findViewById(R.id.contactNumber)
            etName = findViewById(R.id.etContactName)
            etPhone = findViewById(R.id.etContactNumber)
            btnAddContact = findViewById(R.id.btnAddContact)

            btnAddContact?.setOnClickListener {

                if (etPhone.text.toString().isEmpty() || etName.text.toString().isEmpty()) {
                   Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show()
                } else  {
                    contacts.add(Person(etName.text.toString(), etPhone.text.toString()))
                    etName.text = null
                    etPhone.text = null
                    listFragment.notifyDataSetChanged()
                }
            }

            onItemClicked(Person("",""))

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onItemClicked(person: Person) {
        Log.e("XX", person.toString())
        tvName?.let {
            it.text = person.contactName
        }
        tvPhone?.let {
            it.text = person.contactNumber
        }
    }

    fun getContactList(): ArrayList<Person> {
        contacts.add(Person("Aswin", "9876543210"))
        contacts.add(Person("Achan", "9876543211"))
        contacts.add(Person("Amma", "9876543212"))
        contacts.add(Person("Chechi", "9876543213"))

        return contacts
    }
}