package com.example.android.politicalpreparedness.database.domainModels

import android.os.Parcelable
import com.example.android.politicalpreparedness.network.models.Address
import com.example.android.politicalpreparedness.network.models.Channel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainOfficial (
    val name: String,
    val address: List<DomainAddress> = emptyList(),
    val party: String = "",
    val phones: List<String> = emptyList(),
    val urls: List<String> = emptyList(),
    val photoUrl: String = "",
    val channels: List<DomainChannel> = emptyList()
): Parcelable