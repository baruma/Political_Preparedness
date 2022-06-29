package com.example.android.politicalpreparedness.network.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "state_table")
data class StateEntity (
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "administration_body")
    val administrationBody: String
)
