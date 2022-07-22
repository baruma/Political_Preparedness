package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainAddress
import com.example.android.politicalpreparedness.models.DomainAdministrationBody
import com.example.android.politicalpreparedness.network.mapper.ApiToDomainMapper
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCIAdministrationBody(
        val name: String? = null,
        val electionInfoUrl: String? = null,
        val votingLocationFinderUrl: String? = null,
        val ballotInfoUrl: String? = null,
        val correspondenceAddress: GCIAddress? = null
)

fun GCIAdministrationBody.toDomainModel(): DomainAdministrationBody {
        return DomainAdministrationBody (
                name ?: "",
                electionInfoUrl!!,
                votingLocationFinderUrl!!,
                ballotInfoUrl!!,
                correspondenceAddress!!.toDomainModel()
        )
}