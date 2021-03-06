package com.example.android.politicalpreparedness.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainDivision (
    val id: String = "",
    val country: String? = "",
    val state: DomainState?
): Parcelable