package com.mobility.myapplication.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created By JISHAN ANSARI On 10/25/2019
 */
@Entity(
    tableName = "dob_table",
    foreignKeys = [ForeignKey(
        entity = Results::class,
        parentColumns = ["result_id"],
        childColumns = ["dob_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Dob(
    @PrimaryKey(autoGenerate = true)
    var dob_id: Int = 0,
    @SerializedName("age")
    @Expose
    var age: Int? = null
)