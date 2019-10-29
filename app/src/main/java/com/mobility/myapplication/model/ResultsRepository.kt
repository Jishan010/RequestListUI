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
            with(Results())
            {
                result_id = results[0].result_id!!
                gender = results[0].gender
                email = results[0].email
                messageStatus = results[0].messageStatus
                resultDao?.addResult(this)
            }

            with(Name())
            {
                name_id = results[0].result_id!!
                title = results[0].title
                first = results[0].first
                last = results[0].last
                resultDao?.addName(this)
            }

            with(Location())
            {
                location_id = results[0].result_id!!
                city = results[0].city
                state = results[0].state
                country = results[0].country
                resultDao?.addLocation(this)
            }

            with(Picture())
            {
                picture_id = results[0].result_id!!
                large = results[0].large
                resultDao?.addPicture(this)
            }

            with(Dob())
            {
                dob_id = results[0].result_id!!
                age = results[0].age
                resultDao?.addDob(this)
            }

            return null
        }
    }

    companion object {
        var resultDao: ResultDao? = null
    }

}
