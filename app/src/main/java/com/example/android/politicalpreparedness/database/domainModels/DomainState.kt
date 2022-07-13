package com.example.android.politicalpreparedness.database.domainModels

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainState (
    val name: String,
    val administrationBody: DomainAdministrationBody? = null
): Parcelable