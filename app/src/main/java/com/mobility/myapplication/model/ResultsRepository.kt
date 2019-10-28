package com.mobility.myapplication.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.mobility.myapplication.Constants.DELETE
import com.mobility.myapplication.Constants.INSERT
import com.mobility.myapplication.Constants.UPDATE
import retrofit2.http.DELETE

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

class ResultsRepository(application: Application) {

    private var resultsDatabase: ResultsDatabase? = null
    private var userList: LiveData<List<ResultJoinData>>? = null

    val users: LiveData<List<ResultJoinData>>
        get() {
            userList = resultDao?.getResultNameDataList()!!
            return userList!!
        }

    init {
        resultsDatabase = ResultsDatabase.getInstance(application)
        resultDao = resultsDatabase!!.getResultDao()
    }

    fun restoreResult(resultJoinData: ResultJoinData) {
        RestoreOperationAsyncTask().execute(resultJoinData)
    }

    fun updateResult(results: Results) {
        DataOperationAsyncTask(UPDATE).execute(results)
    }

    fun deleteResult(user: Results) {
        DataOperationAsyncTask(DELETE).execute(user)
    }

    //async task for database operations
    class DataOperationAsyncTask(operationType: String) : AsyncTask<Results, Void, Void>() {
        private var operationType: String? = null

        init {
            this.operationType = operationType
        }

        override fun doInBackground(vararg results: Results): Void? {
            when (operationType) {
                UPDATE -> resultDao?.updateResult(results[0])
                DELETE -> resultDao?.deleteResult(results[0])
                INSERT -> resultDao?.addResult(results[0])
            }
            return null
        }
    }


    class RestoreOperationAsyncTask : AsyncTask<ResultJoinData, Void, Void>() {


        override fun doInBackground(vararg results: ResultJoinData): Void? {
            val result = Results()
            result.result_id = results[0].result_id!!
            result.gender = results[0].gender
            result.email = results[0].email
            result.messageStatus = results[0].messageStatus
            resultDao?.addResult(result)

            val name = Name()
            name.name_id = results[0].result_id!!
            name.title = results[0].title
            name.first = results[0].first
            name.last = results[0].last
            resultDao?.addName(name)

            val location = Location()
            location.location_id = results[0].result_id!!
            location.city = results[0].city
            location.state = results[0].state
            location.country = results[0].country
            resultDao?.addLocation(location)

            val picture = Picture()
            picture.picture_id = results[0].result_id!!
            picture.large = results[0].large
            resultDao?.addPicture(picture)

            val dob = Dob()
            dob.dob_id = results[0].result_id!!
            dob.age = results[0].age
            resultDao?.addDob(dob)

            return null
        }
    }

    companion object {
        var resultDao: ResultDao? = null
    }

}
