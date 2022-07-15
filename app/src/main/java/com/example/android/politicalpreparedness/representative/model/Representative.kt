package com.example.android.politicalpreparedness.representative.model

import com.example.android.politicalpreparedness.network.models.Office
import com.example.android.politicalpreparedness.network.models.Official

data class Representative (
        val official: Official,
        val office: Office
)

private val serialized: String? = null

@Transient
private val not_serialized: String? = null