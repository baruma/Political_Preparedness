package com.example.android.politicalpreparedness.database.domainModels

data class DomainDropOffLocations(
    val address: DomainAddress? = null,
    val notes: String? = null,
    val pollingHours: String? = null,
    val name: String? = null,
    val voterServices: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val sources: DomainSources? = null
)