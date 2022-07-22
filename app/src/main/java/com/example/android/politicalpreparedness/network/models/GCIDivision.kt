package com.example.android.politicalpreparedness.network.models

import android.os.Parcelable
import com.example.android.politicalpreparedness.models.DomainAddress
import com.example.android.politicalpreparedness.models.DomainDivision
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GCIDivision(
    val id: String,
    val country: String? = "",
    val state: String? = ""
) : Parcelable

fun GCIDivision.toDomainModel(): DomainDivision {
    return DomainDivision(
        id,
        country,
        null
    )
}