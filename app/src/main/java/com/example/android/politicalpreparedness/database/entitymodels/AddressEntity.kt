package com.example.android.politicalpreparedness.database.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "address_table")
data class AddressEntity (
    @ColumnInfo(name = "line_1") val line1: String,
    @ColumnInfo(name = "line_2") val line2: String,
    val city: String,
    val state: String,
    val zip: Int
)