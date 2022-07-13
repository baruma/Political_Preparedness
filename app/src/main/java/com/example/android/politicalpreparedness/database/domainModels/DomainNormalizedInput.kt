package com.example.android.politicalpreparedness.database.domainModels

import com.squareup.moshi.JsonClass

data class DomainNormalizedInput(
    val locationName: String? = null,
    val line1: String? = null,
    val line2: String? = null,
    val line3: String? = null,
    val city: String? = null,
    val state: String? = null,
    val zip: String? = null
)


