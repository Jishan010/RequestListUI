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
    tableName = "picture_table",
    foreignKeys = [ForeignKey(
        entity = Results::class,
        parentColumns = ["result_id"],
        childColumns = ["picture_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Picture(
    @PrimaryKey(autoGenerate = true)
    var picture_id: Int = 0,
    @SerializedName("medium")
    @Expose
    var large: String? = null
)