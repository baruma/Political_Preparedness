package com.example.android.politicalpreparedness.database.entitymodels

import androidx.room.*
import com.squareup.moshi.*
import java.util.*

@Entity(tableName = "election_table")
data class ElectionEntity(
        @PrimaryKey val id: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "electionDay" ) val electionDay: Date,
        @Json(name="ocdDivisionId") val divisionID: String
)
