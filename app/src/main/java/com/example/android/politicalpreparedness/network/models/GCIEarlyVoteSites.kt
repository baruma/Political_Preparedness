package com.example.android.politicalpreparedness.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCIEarlyVoteSites (
    val address: GCIAddress? = null,
    val notes: String? = null,
    val voterServices: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val sources: GCISources? = null
)