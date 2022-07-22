package com.example.android.politicalpreparedness.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DomainSources(
    val name: String? = null,
    val official: Boolean = false,
)