package com.mobility.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mobility.myapplication.model.Name
import com.mobility.myapplication.model.ResultNameData
import com.mobility.myapplication.model.Results
import com.mobility.myapplication.model.UserRepository

/**
 *
 * Created By J7202687 On 10/22/2019
 */

open class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var userRepository: UserRepository? = null
    private var userList: LiveData<List<ResultNameData>>? = null
    private var userName: Name? = null

    init {
        userRepository = UserRepository(application)
        userList = userRepository!!.users
    }

    fun getUserList(): LiveData<List<ResultNameData>>? {
        return userList
    }

    fun getUserName(id : Int) : Name
    {
        userName= userRepository!!.getUserName(id)
        return userName!!
    }

    fun insertUser(result: Results) {
        userRepository?.insertUser(result)
    }

  /*  fun updateUser(user: User) {
        userRepository?.updateNote(user)
    }

    fun deleteUser(user: User) {
        userRepository?.deleteNote(user)
    }*/
}