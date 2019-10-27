package com.mobility.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mobility.myapplication.model.ResultJoinData
import com.mobility.myapplication.model.Results
import com.mobility.myapplication.model.UserRepository

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

open class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepository: UserRepository? = null
    private var userList: LiveData<List<ResultJoinData>>? = null

    init {
        userRepository = UserRepository(application)
        userList = userRepository!!.users
    }

    fun getResultList(): LiveData<List<ResultJoinData>>? {
        return userList
    }

    fun updateResult(result: Results) {
        userRepository?.updateResult(result)
    }
    fun deleteResult(result: Results) {
        userRepository?.deleteResult(result)
    }
}