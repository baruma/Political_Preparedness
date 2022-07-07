package com.example.android.politicalpreparedness.database.domainModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainAdministration (
    val name: String,
    val electionInfoURL: String,
    val votingLocationURL: String,
    val ballotInfoURL: String,
    val correspondenceAddress: DomainAddress? = null
): Parcelable