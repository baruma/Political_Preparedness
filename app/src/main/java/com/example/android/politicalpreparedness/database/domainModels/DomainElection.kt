package com.example.android.politicalpreparedness.database.domainModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class DomainElection(
    val id: Int,
    val name: String,
    val electionDay: Date,
    val divisionId: String,
) : Parcelable