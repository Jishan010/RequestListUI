package com.mobility.myapplication.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created By JISHAN ANSARI On 10/25/2019
 */

@Entity(
    tableName = "location_table",
    foreignKeys = [ForeignKey(
        entity = Results::class,
        parentColumns = ["result_id"],
        childColumns = ["location_id"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Location(

    @PrimaryKey(autoGenerate = true)
    var location_id: Int = 0,
    @SerializedName("city")
    var city: String? = null,
    @SerializedName("state")
    var state: String? = null,
    @SerializedName("country")
    var country: String? = null
)
