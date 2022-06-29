package com.example.android.politicalpreparedness.database.domainModels

import android.os.Parcelable
import com.example.android.politicalpreparedness.network.models.Address
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class DomainState (
    val name: String,
    val administrationBody: DomainAdministration
): Parcelable