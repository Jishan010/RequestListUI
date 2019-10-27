package com.mobility.myapplication.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

class UserRepository(application: Application) {

    private var userDatabase: UserDatabase? = null
    private var userList: LiveData<List<ResultNameData>>? = null

    val users: LiveData<List<ResultNameData>>
        get() {
            userList = userDao?.getResultNameDataList()!!
            return userList!!
        }

    init {
        userDatabase = UserDatabase.getInstance(application)
        userDao = userDatabase!!.getResultDao()
    }


    fun updateUser(results: Results) {
        UpdateAsyncTask().execute(results)
    }

    fun deleteUser(user: Results) {
        DeleteAsyncTask().execute(user)
    }


    //async task for updating users
    class UpdateAsyncTask : AsyncTask<Results, Void, Void>() {
        override fun doInBackground(vararg results: Results): Void? {
            userDao?.updateResult(results[0])
            return null
        }
    }

     //async task for deleting users
     class DeleteAsyncTask : AsyncTask<Results, Void, Void>() {
         override fun doInBackground(vararg results: Results): Void? {
             userDao?.deleteResult(results[0])
             return null
         }
     }

    companion object {
        var userDao: ResultDao? = null
    }

}
