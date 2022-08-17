package com.opensource.coroutineviewmodelscope.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.opensource.coroutineviewmodelscope.helpers.UserRepository
import com.opensource.coroutineviewmodelscope.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserViewModel : ViewModel() {

    private var userRepository: UserRepository = UserRepository()
    var user: MutableLiveData<List<User>> = MutableLiveData()

    fun getUserData() {
        viewModelScope.launch {
            var result: List<User>? = null
            withContext(Dispatchers.IO) {
                result = userRepository.getUsersList()
            }
            user.value = result
        }
    }
}