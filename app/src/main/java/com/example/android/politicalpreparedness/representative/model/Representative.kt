package com.example.android.politicalpreparedness.representative.model

import com.example.android.politicalpreparedness.network.models.Division
import com.example.android.politicalpreparedness.network.models.Office
import com.example.android.politicalpreparedness.network.models.Official
import com.squareup.moshi.Json

data class Representative (
        @Json(name = "divisions") val divisions: Division?,
        val official: Official,
        val office: Office
)