package com.example.android.politicalpreparedness.database.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "division_table")
data class DivisionEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "state") val state: String,  // supposed to be domain state
)

// Make another label for this view
// Move on to saving the election