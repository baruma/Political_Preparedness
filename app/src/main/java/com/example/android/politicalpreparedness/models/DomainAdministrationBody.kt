package com.example.android.politicalpreparedness.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainAdministrationBody(
    val name: String,
    val electionInfoURL: String,
    val votingLocationURL: String,
    val ballotInfoURL: String,
    val correspondenceAddress: DomainAddress? = null
) : Parcelable

fun DomainAdministrationBody.asDomainModel(): DomainAdministrationBody {
    return DomainAdministrationBody(
        name,
        electionInfoURL,
        votingLocationURL,
        ballotInfoURL,
        correspondenceAddress = null
    )
}