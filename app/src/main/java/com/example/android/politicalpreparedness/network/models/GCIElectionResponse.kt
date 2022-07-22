package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainAddress
import com.example.android.politicalpreparedness.models.DomainElection
import com.example.android.politicalpreparedness.network.apimodels.ElectionAPIModel
import com.example.android.politicalpreparedness.network.mapper.ApiToDomainMapper
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCIElectionResponse(
        val kind: String,
        val elections: List<ElectionAPIModel>
)

fun GCIElectionResponse.toDomainModel(): List<DomainElection> {
        val electionEntities = this.elections

        val domainElections = electionEntities.map { electionAPIModel ->
                DomainElection(
                        electionAPIModel.id,
                        electionAPIModel.name,
                        electionAPIModel.electionDay,
                        electionAPIModel.division
                )
        }

        return domainElections
}