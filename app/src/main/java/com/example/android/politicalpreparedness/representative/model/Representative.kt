package com.example.android.politicalpreparedness.representative.model

import com.example.android.politicalpreparedness.network.models.GCIDivision
import com.example.android.politicalpreparedness.network.models.GCIOffice
import com.example.android.politicalpreparedness.network.models.GCIOfficial
import com.squareup.moshi.Json

data class Representative (
        @Json(name = "divisions")
        val divisions: GCIDivision?,
        val official: List<GCIOfficial>,
        val office: List<GCIOffice>
)