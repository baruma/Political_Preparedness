package com.example.android.politicalpreparedness.models

data class DomainEarlyVoteSites(
    val address: DomainAddress? = null,
    val notes: String? = null,
    val voterServices: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val sources: DomainSources? = null
)