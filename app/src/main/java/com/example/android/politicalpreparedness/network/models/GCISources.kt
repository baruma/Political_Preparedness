package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainSources
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCISources (
    val name: String? = null,
    val official: Boolean = false,
)

fun GCISources.toDomainModel(): DomainSources {
    return DomainSources(name, official)
}