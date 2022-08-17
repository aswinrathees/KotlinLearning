package com.opensource.coroutineviewmodelscope.helpers

import com.opensource.coroutineviewmodelscope.model.User

class UserRepository {

    fun getUsersList(): List<User> {
        var listUser: List<User> = listOf(
            User(1, "Aswin"),
            User(2, "Rathees"),
            User(3, "Mini"),
            User(4, "Rashmitha")
        )

        return listUser
    }
}