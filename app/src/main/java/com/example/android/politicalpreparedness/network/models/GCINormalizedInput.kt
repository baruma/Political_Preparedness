package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainNormalizedInput
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class GCINormalizedInput (
        val locationName: String? = null,
        val line1: String? = null,
        val line2: String? = null,
        val line3: String? = null,
        val city: String? = null,
        val state: String? = null,
        val zip: String? = null
)

fun GCINormalizedInput.toDomainModel(): DomainNormalizedInput {
        return DomainNormalizedInput(
                locationName,
                line1,
                line2,
                line3,
                city,
                state,
                zip
        )
}