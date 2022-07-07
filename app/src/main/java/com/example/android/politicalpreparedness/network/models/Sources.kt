package com.example.android.politicalpreparedness.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sources (
    val name: String? = null,
    val official: Boolean = false,
)