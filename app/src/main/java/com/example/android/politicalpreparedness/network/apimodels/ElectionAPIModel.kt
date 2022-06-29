package com.example.android.politicalpreparedness.network.apimodels

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.example.android.politicalpreparedness.network.models.Division
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)

data class ElectionAPIModel (
    val id: Int,
    val name: String,
    val electionDay: Date,
    @Json(name="ocdDivisionId")
    val division: Division
)