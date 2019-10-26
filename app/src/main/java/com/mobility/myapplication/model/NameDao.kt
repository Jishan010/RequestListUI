package com.mobility.myapplication.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * Created By JISHAN ANSARI On 10/26/2019
 */

@Dao
interface NameDao {

    @Insert
    fun addName(name: Name)

    @Query("select * from name_table where name_id=:name_id")
    fun getNameList(name_id: Int): Name
}
