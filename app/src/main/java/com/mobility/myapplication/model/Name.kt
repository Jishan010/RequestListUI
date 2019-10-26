package com.mobility.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import androidx.room.ForeignKey.CASCADE

/**
 * Created By JISHAN ANSARI On 10/25/2019
 */


@Entity(
    tableName = "name_table",
    foreignKeys = [ForeignKey(
        entity = Results::class,
        parentColumns = ["result_id"],
        childColumns = ["id"],
        onDelete = CASCADE
    )]
)
data class Name(

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "result_id_column")
    var resultId: Int = 0,

    @SerializedName("title")
    @Expose
    var title: String? = null,

    @SerializedName("first")
    @Expose
    var first: String? = null,
    @SerializedName("last")
    @Expose
    var last: String? = null
)