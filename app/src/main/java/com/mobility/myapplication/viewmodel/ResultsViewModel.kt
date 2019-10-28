package com.mobility.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mobility.myapplication.model.*

/**
 *
 * Created By JISHAN ANSARI On 10/26/2019
 */

open class ResultsViewModel(application: Application) : AndroidViewModel(application) {

    private var resultsRepository: ResultsRepository? = null
    private var userList: LiveData<List<ResultJoinData>>? = null

    init {
        resultsRepository = ResultsRepository(application)
        userList = resultsRepository!!.users
    }

    fun getResultList(): LiveData<List<ResultJoinData>>? {
        return userList
    }

    fun updateResult(result: Results) {
        resultsRepository?.updateResult(result)
    }

    fun deleteResult(result: Results) {
        resultsRepository?.deleteResult(result)
    }

    fun restoreResults(resultJoinData: ResultJoinData) {
        resultsRepository?.restoreResult(resultJoinData)
    }
}