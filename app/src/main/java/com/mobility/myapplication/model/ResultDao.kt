package com.mobility.myapplication.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */
@Dao
interface ResultDao {

    @Query("select * from result_table")
    fun getResultLists(): LiveData<List<Results>>

    @Insert
    fun addResult(results: Results)
}
