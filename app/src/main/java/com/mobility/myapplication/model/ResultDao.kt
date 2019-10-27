package com.mobility.myapplication.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */
@Dao
interface ResultDao {

    @Query("select * from result_table")
    fun getResultLists(): LiveData<List<Results>>

    @Query("select * from result_table where result_id=:result_id")
    fun getResult(result_id: Int): Results

    @Insert
    fun addResult(results: Results)

    @Update
    fun updateResult(results: Results)

    @Insert
    fun addLocation(location: Location)

    @Insert
    fun addName(name: Name)

    @Insert
    fun addPicture(picture: Picture)

    @Insert
    fun addDob(dob: Dob)

    @Query("select * from name_table where name_id=:name_id")
    fun getNameList(name_id: Int): Name

    @Query("select result_table.email ,result_table.result_id,result_table.messageStatus, result_table.gender  ,name_table.title ,name_table.first,name_table.last,location_table.city,location_table.state,location_table.country ,dob_table.age,picture_table.large from result_table INNER JOIN name_table ON result_table.result_id=name_table.name_id INNER JOIN location_table ON   result_table.result_id=location_table.location_id  INNER JOIN dob_table ON result_table.result_id=dob_table.dob_id  INNER JOIN picture_table ON result_table.result_id=picture_table.picture_id ")
    fun getResultNameDataList(): LiveData<List<ResultNameData>>
}
