package com.example.android.politicalpreparedness.network.entitymodels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "administration_table")
data class AdministrationEntity (
    @PrimaryKey val name: String,
    @ColumnInfo(name = "election_info_url") val electionInfoUrl: String,
    @ColumnInfo (name = "voting_location_finder_url") val votingLocationFinderUrl: String,
    @ColumnInfo (name = "ballot_info_for_url") val ballotInforUrl: String,
    @ColumnInfo (name = "correspondence_ address") val correspondenceAddress: String
)