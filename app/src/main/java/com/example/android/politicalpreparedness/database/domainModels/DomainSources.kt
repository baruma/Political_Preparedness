package com.example.android.politicalpreparedness.database.domainModels

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DomainSources(
    val name: String? = null,
    val official: Boolean = false,
)