package com.example.android.politicalpreparedness.network.mapper

import com.example.android.politicalpreparedness.database.domainModels.*
import com.example.android.politicalpreparedness.network.models.*

// This pattern you see below where nested models map other nested models is called Cascading.
object ApiToDomainMapper {

    fun mapToDomainAddress(apiAddress: Address): DomainAddress {
        return DomainAddress(
            apiAddress.line1,
            apiAddress.line2,
            apiAddress.city,
            apiAddress.state,
            apiAddress.zip
        )
    }

    fun mapApiToDomainAdministration(apiAdministrationBody: AdministrationBody): DomainAdministration {
        return DomainAdministration(
            apiAdministrationBody.name!!,
            apiAdministrationBody.electionInfoUrl!!,
            apiAdministrationBody.votingLocationFinderUrl!!,
            apiAdministrationBody.ballotInfoUrl!!,
            mapToDomainAddress(apiAdministrationBody.correspondenceAddress!!)
        )
    }

    fun mapFromAPIStateToDomainState(apiState: State): DomainState {
        return DomainState(
            apiState.name,
            mapApiToDomainAdministration(apiState.electionAdministrationBody)
        )
    }

    fun mapFromAPIDivisionToDomainDivision(apiDivision: Division): DomainDivision {
        return DomainDivision(
            apiDivision.id,
            apiDivision.country,
            apiDivision.state
        )
    }

    // First have to map the Payload to ElectionResponse
    // Map the response api objects to domain models
    // Issue is with Division
    fun mapFromElectionResponseToDomainElection(APIPayload: ElectionResponse): List<DomainElection> {
        val electionEntities = APIPayload.elections

        val domainElections = electionEntities.map { electionAPIModel ->
            DomainElection(
                electionAPIModel.id,
                electionAPIModel.name,
                electionAPIModel.electionDay,
                electionAPIModel.division,
                null //TODO
            )
        }

        return domainElections
    }

//    fun mapFromAdministrationAPIResponseToDomainAdminisstration(administrationAPIResponse: AdministrationBody): DomainAdministration {
//        return DomainAdministration(
//            administrationAPIResponse.name!!,
//            administrationAPIResponse.electionInfoUrl!!,
//            administrationAPIResponse.votingLocationFinderUrl!!,
//            administrationAPIResponse.ballotInfoUrl!!,
//            administrationAPIResponse.correspondenceAddress!!
//        )
//    }
//
//    fun mapFromStateResponseToDomainState(domainAdministration: DomainAdministration, stateName: String): DomainState {
//        return DomainState(
//            stateName,
//            domainAdministration
//        )
//    }

}