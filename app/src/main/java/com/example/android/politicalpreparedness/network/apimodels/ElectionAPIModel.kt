package com.example.android.politicalpreparedness.network.apimodels

import com.example.android.politicalpreparedness.models.DomainElection
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)

data class ElectionAPIModel (
    val id: Int,
    val name: String,
    val electionDay: Date,
    @Json(name="ocdDivisionId")
    val division: String
)

fun ElectionAPIModel.toDomainModel(): DomainElection {
    return DomainElection(id, name, electionDay, division)
}