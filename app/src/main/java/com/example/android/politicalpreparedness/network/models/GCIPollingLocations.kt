package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainPollingLocations
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCIPollingLocations (
    val address: GCIAddress? = null,
    val notes: String? = null,
    val pollingHours: String? = null,
    val name: String? = null,
    val voterService: String? = null,
    val startDate: String? = null,
    val endDate: String? = null,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val sources: GCISources? = null
)

fun GCIPollingLocations.toDomainModel(): DomainPollingLocations {
    return DomainPollingLocations(
        address!!.toDomainModel(),
        notes,
        pollingHours,
        name,
        voterService,
        startDate,
        endDate,
        latitude,
        longitude,
        sources!!.toDomainModel()
    )
}