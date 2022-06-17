package com.example.android.politicalpreparedness.database.domainModels

import java.sql.Date

data class DomainElection(
    val id: Int,
    val name: String,
    val electionDay: Date,
    val division: String,
)