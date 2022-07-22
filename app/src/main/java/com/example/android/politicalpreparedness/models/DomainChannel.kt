package com.example.android.politicalpreparedness.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DomainChannel (
        val type: String,
        val id: String
): Parcelable