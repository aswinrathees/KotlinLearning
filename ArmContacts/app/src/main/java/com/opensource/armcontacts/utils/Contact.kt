package com.opensource.armcontacts.utils

import java.util.Date

data class Contact(
    var name: String = "",
    var phone: String = "",
    var email: String = "",
    var appUserEmail: String = "",
    var created: Date = Date(),
    var updated: Date = Date())
