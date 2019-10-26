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

    @Insert
    fun addLocation(location: Location)


    @Query("select result_table.email , result_table.gender  ,name_table.title ,name_table.first,name_table.last,location_table.city,location_table.state,location_table.country  from result_table INNER JOIN name_table ON result_table.result_id=name_table.name_id INNER JOIN location_table ON   result_table.result_id=location_table.location_id  ")
    fun getResultNameDataList(): LiveData<List<ResultNameData>>
}
