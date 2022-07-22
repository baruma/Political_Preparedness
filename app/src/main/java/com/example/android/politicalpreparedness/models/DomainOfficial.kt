package com.example.android.politicalpreparedness.models

import android.os.Parcelable
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