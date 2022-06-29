package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.network.apimodels.ElectionAPIModel
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ElectionResponse(
        val kind: String,
        val elections: List<ElectionAPIModel>
)