package com.opensource.retrofitdemoone

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.opensource.retrofitdemoone.helpers.RetrofitInstance
import com.opensource.retrofitdemoone.helpers.UserService
import com.opensource.retrofitdemoone.model.UserDetails
import com.opensource.retrofitdemoone.model.UserDetailsItem
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var retrofitInstance: UserService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        retrofitInstance =
            RetrofitInstance.getRetrofitInstance().create(UserService::class.java)


        getAllUserData()

        getUserData()

        uploadUserData()
    }

    private fun getAllUserData() {

        val responseLiveData: LiveData<Response<UserDetails>> = liveData {
            //  val response = retrofitInstance.getUsers()
            val response = retrofitInstance.getUsersSorted(3)
            emit(response)
        }

        responseLiveData.observe(this) {
            val userList = it.body()?.listIterator()
            if (userList != null) {
                while (userList.hasNext()) {
                    val userItem = userList.next()
                    val response = "UserItem : Title" + userItem.title +
                            "\n ID : ${userItem.id}"
                    Log.i(
                        "RetrofitDemoOne", " - UserItem : Title" + userItem.title +
                                "\n ID : ${userItem.id}"
                    )
                    textView.append(response)
                }
            }
        }
    }

    private fun getUserData() {
        val pathResponseLiveData: LiveData<Response<UserDetailsItem>> = liveData {
            val pathResponse = retrofitInstance.getUserById(57)
            emit(pathResponse)
        }

        pathResponseLiveData.observe(this) {
            val data = it.body()?.title.toString()
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadUserData() {
        val user = UserDetailsItem(true, 1, "Custom", 151)

        val uploadResponseLiveData: LiveData<Response<UserDetailsItem>> = liveData {
            val uploadDataResponse = retrofitInstance.uploadUser(user)
            emit(uploadDataResponse)
        }

        uploadResponseLiveData.observe(this) {
            val postStatus = it.body()
            if (postStatus != null) {
                Log.i(
                    "RetrofitDemoOne POST", " - UserItem : Title" + postStatus.title +
                            "\n ID : ${postStatus.id}"
                )
            }
        }
    }
}