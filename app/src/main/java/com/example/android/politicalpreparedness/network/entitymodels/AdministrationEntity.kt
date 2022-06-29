package com.example.android.politicalpreparedness.network.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import com.example.android.politicalpreparedness.network.models.Address

@Entity(tableName = "administration_table")
data class AdministrationEntity (
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "election_info_url")
    val electionInfoUrl: String,
    @ColumnInfo
    val votingLocationFinderUrl: String,
    @ColumnInfo
    val ballotInforUrl: String,
    @ColumnInfo
    val correspondenceAddress: String
)