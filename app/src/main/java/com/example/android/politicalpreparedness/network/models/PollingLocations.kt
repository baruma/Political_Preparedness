package com.example.android.politicalpreparedness.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PollingLocations (
    val address: Address? = null,
    val notes: String? = null,
    val pollingHours: String? = null,
    val name: String? = null,
    val voterService: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val sources: Sources? = null
)