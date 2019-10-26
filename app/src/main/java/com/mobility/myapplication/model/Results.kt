package com.mobility.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created By JISHAN ANSARI On 10/25/2019
 */

@Entity(tableName = "result_table")
data class Results(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    var result_id: Int = 0,

    @SerializedName("gender")
    @Expose
    var gender: String? = null,

    @Ignore
    @SerializedName("name")
    @Expose
    var name: Name? = null,

    @Ignore
    @SerializedName("location")
    @Expose
    var location: Location? = null,

    @Ignore
    @SerializedName("dob")
    @Expose
    var dob: Dob? = null,

    @Ignore
    @SerializedName("picture")
    @Expose
    var picture: Picture? = null,

    @SerializedName("email")
    @Expose
    var email: String? = null

)
