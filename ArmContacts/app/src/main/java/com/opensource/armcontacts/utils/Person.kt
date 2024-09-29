package com.opensource.armcontacts.utils

import com.backendless.BackendlessUser

data class Person(
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = ""
)

object ApplicationUser {
    var user: BackendlessUser = BackendlessUser()
    lateinit var contactList: List<Contact>
}
