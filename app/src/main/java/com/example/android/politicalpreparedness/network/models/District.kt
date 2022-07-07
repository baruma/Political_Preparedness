package com.example.android.politicalpreparedness.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class District (
        val name: String? = null,
        val scope: String? = null,
        val id: String? = null
)