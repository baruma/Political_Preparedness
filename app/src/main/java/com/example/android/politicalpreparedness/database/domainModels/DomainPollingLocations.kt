package com.example.android.politicalpreparedness.database.domainModels

import com.squareup.moshi.JsonClass

data class DomainPollingLocations(
    val address: DomainAddress? = null,
    val notes: String? = null,
    val pollingHours: String? = null,
    val name: String? = null,
    val voterService: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val sources: DomainSources? = null
)
