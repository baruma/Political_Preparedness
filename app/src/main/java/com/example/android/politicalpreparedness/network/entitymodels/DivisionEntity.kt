package com.example.android.politicalpreparedness.network.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "division_table")
data class DivisionEntity(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "country") val country: String,
    @ColumnInfo(name = "state") val state: String,  // supposed to be domain state
)