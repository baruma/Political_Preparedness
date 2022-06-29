package com.example.android.politicalpreparedness.network.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import java.util.*

@Entity(tableName = "division_table")
data class DivisionEntity(
    @Json(name="ocdDivisionId")
    val division: String,
    @PrimaryKey val id: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "state")
    val state: String,  // supposed to be domain state
)