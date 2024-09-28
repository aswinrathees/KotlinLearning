package com.opensource.armcontacts.utils

import java.util.Date

data class Contact(
    val name: String = "",
    val phone: String = "",
    val email: String = "",
    val appUserEmail: String = "",
    val created: Date = Date(),
    val updated: Date = Date())
