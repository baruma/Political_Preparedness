package com.example.android.politicalpreparedness.database.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "state_table")
data class StateEntity (
    @PrimaryKey val name: String,
    @ColumnInfo(name = "administration_body") val administrationBody: String
)
