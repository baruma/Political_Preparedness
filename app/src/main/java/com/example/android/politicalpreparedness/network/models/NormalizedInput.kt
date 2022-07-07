package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NormalizedInput (
        val locationName: String? = null,
        val line1: String? = null,
        val line2: String? = null,
        val line3: String? = null,
        val city: String? = null,
        val state: String? = null,
        val zip: String? = null
)
