package com.example.android.politicalpreparedness.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainState (
    val name: String,
    val administrationBody: DomainAdministrationBody? = null
): Parcelable

