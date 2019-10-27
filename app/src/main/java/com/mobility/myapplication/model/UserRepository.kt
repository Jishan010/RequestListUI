package com.mobility.myapplication.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

/**
 *
 * Created By J7202687 On 10/22/2019
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

    fun insertUser(results: Results) {
        InsertAsyncTask().execute(results)
    }

    fun updateUser(results: Results) {
        UpdateAsyncTask().execute(results)
    }
    /*   fun updateNote(user: User) {
           UpdateAsyncTask().execute(user)
       }

       fun deleteNote(user: User) {
           DeleteAsyncTask().execute(user)
       }*/


    //async task for inserting users
    class InsertAsyncTask : AsyncTask<Results, Void, Void>() {
        override fun doInBackground(vararg results: Results): Void? {
            userDao?.addResult(results[0])
            return null
        }
    }

    class UpdateAsyncTask : AsyncTask<Results, Void, Void>() {
        override fun doInBackground(vararg results: Results): Void? {
            userDao?.updateResult(results[0])
            return null
        }
    }

    /* //async task for deleting users
     class DeleteAsyncTask : AsyncTask<User, Void, Void>() {
         override fun doInBackground(vararg users: User): Void? {
             userDao?.deleteUser(users[0])
             return null
         }
     }

     //async task for updating users
    */

    companion object {
        var userDao: ResultDao? = null
    }

}
