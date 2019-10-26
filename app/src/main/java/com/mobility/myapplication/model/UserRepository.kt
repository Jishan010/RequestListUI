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
    private var userList: LiveData<List<Results>>? = null

    val users: LiveData<List<Results>>
        get() {
            userList = userDao?.getResultLists()!!
            return userList!!
        }

    init {
        userDatabase = UserDatabase.getInstance(application)
        userDao = userDatabase!!.getResultDao()
        nameDao = userDatabase!!.getNameDao()
    }

    fun insertUser(results: Results) {
        InsertAsyncTask().execute(results)
    }

    fun getUserName(id: Int): Name {
        return nameDao!!.getNameList(id)
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

    /* //async task for deleting users
     class DeleteAsyncTask : AsyncTask<User, Void, Void>() {
         override fun doInBackground(vararg users: User): Void? {
             userDao?.deleteUser(users[0])
             return null
         }
     }

     //async task for updating users
     class UpdateAsyncTask : AsyncTask<User, Void, Void>() {
         override fun doInBackground(vararg users: User): Void? {
             userDao?.updateUser(users[0])
             return null
         }
     }*/

    companion object {
        var userDao: ResultDao? = null
        var nameDao: NameDao? = null
    }

}
