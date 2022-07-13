package com.example.android.politicalpreparedness.network.mapper

import com.example.android.politicalpreparedness.database.domainModels.*
import com.example.android.politicalpreparedness.network.apimodels.ElectionAPIModel
import com.example.android.politicalpreparedness.network.models.*
import com.example.android.politicalpreparedness.network.models.VoterInfoResponse
import com.squareup.moshi.JsonClass

// This pattern you see below where nested models map other nested models is called Cascading.
object ApiToDomainMapper {

    /* MAPPING ELECTION DATA MAPS */

    fun mapToDomainAddress(apiAddress: Address): DomainAddress {
        return DomainAddress(
            apiAddress.line1,
            apiAddress.line2,
            apiAddress.city,
            apiAddress.state,
            apiAddress.zip
        )
    }

    fun mapApiToDomainAdministration(apiAdministrationBody: AdministrationBody): DomainAdministrationBody {
        return DomainAdministrationBody(
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

    fun mapFromAPIDivisionToDomainDivision(apiDivision: Division, apistate: State): DomainDivision {
        return DomainDivision(
            apiDivision.id,
            apiDivision.country,
            mapFromAPIStateToDomainState(apistate))
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
                electionAPIModel.division //TODO
            )
        }

        return domainElections
    }

    fun mapFromAdministrationAPIResponseToDomainAdminisstration(administrationAPIResponse: AdministrationBody): DomainAdministrationBody {
        return DomainAdministrationBody(
            administrationAPIResponse.name!!,
            administrationAPIResponse.electionInfoUrl!!,
            administrationAPIResponse.votingLocationFinderUrl!!,
            administrationAPIResponse.ballotInfoUrl!!,
            mapToDomainAddress(administrationAPIResponse.correspondenceAddress!!)
        )
    }

    fun mapFromStateResponseToDomainState(domainAdministration: DomainAdministrationBody, stateName: String): DomainState {
        return DomainState(
            stateName,
            domainAdministration
        )
    }

    /* VOTER INFO RESPONSE MAPS */

    fun mapFromAPIVoterInfoResponseToDomainVoterInfoResponse(voterInfoResponse: VoterInfoResponse): DomainVoterInfoResult {
        return DomainVoterInfoResult(
            voterInfoResponse.kind,
            mapFromElectionAPIToDomainElection(voterInfoResponse.election),
            voterInfoResponse.otherElections.map { mapFromElectionAPIToDomainElection(it) },
            mapFromApiNormalizedInputToDomainApiInput(voterInfoResponse.normalizedInput),
            voterInfoResponse.pollingLocations.map { mapToAPIPollingLocationsToDomainPollingLocations(it) },
            voterInfoResponse.earlyVoteSites.map { mapFromAPIEarlyVoteSitesToDomainEarlyVoteSites(it) },
            voterInfoResponse.dropOffLocation.map { mapFromAPIDropOffLocationsToDomainDropOffLocations(it) },
            voterInfoResponse.contests.map { mapFromAPIContestToDomainContests(it) },
            voterInfoResponse.state.map { mapFromAPIStateToDomainState(it) },
            voterInfoResponse.electionElectionOfficials!!.map { mapFromAPIElectionOfficialsToDomainElectionOfficials(it) },
            voterInfoResponse.mailOnly
        )
    }

    fun mapFromAPIElectionOfficialsToDomainElectionOfficials(electionOfficial: ElectionOfficial): DomainElectionOfficial {
        return DomainElectionOfficial(
            electionOfficial.name,
            electionOfficial.title,
            electionOfficial.phone,
            electionOfficial.fax,
            electionOfficial.emailAddress
        )
    }

    fun mapFromAPIContestToDomainContests(contests: Contests): DomainContests {
        return DomainContests(
            contests.type,
            contests.primaryParty,
            contests.electorateSpecifications,
            contests.special,
            contests.ballotTitle,
            contests.office,
            contests.level,
            contests.roles,
            mapAPIDistrictsToDomainDistricts(contests.district!!),
            contests.numberElected,
            contests.numberVotingFor,
            contests.ballotPlacement,
            mapFromAPICandidatesToDomainCandidates(contests.candidate!!),
            contests.referendumTitle,
            contests.referendumSubtitle,
            contests.referendumUrl,
            contests.referendumText,
            contests.referendumProStatement,
            contests.referendumConStatement,
            contests.referendumPassageThreshold,
            contests.referendumEffectOfAbstain,
            contests.referendumBallotResponse,
            mapFromAPISourcesToDomainSources(contests.sources)
        )
    }

    fun mapFromAPICandidatesToDomainCandidates(candidates: Candidates): DomainCandidates {
        return DomainCandidates(
            candidates.name,
            candidates.party,
            candidates.candidateUrl,
            candidates.phone,
            candidates.photoUrl,
            candidates.email,
            candidates.orderOnBallot,
            mapFromAPIChannelsToDomainChannels(candidates.channels!!)
        )
    }

    fun mapFromAPIChannelsToDomainChannels(channels: Channels): DomainChannel {
        return DomainChannel(channels.type.toString(), channels.id.toString())
    }

    fun mapAPIDistrictsToDomainDistricts(district: District): DomainDistrict {
        return DomainDistrict(
            district.name,
            district.scope,
            district.id
        )
    }


    fun mapFromAPIStateToDomainState(state: State, administrationBody: AdministrationBody): DomainState {
        return DomainState(
            state.name,
            mapApiToDomainAdministration(state.electionAdministrationBody)
        )
    }


//    fun mapFromAPIDivisionToDomainDivision(division: Division, state: State): DomainDivision {
////        val administrationBody = mapApiToDomainAdministration(division.state)
////        return DomainDivision(
////            division.id,
////            division.country,
////        )
//
//        return DomainDivision(
//            division.id,
//            division.country,
//            mapFromAPIStateToDomainState(state)
//        )
//    }

    fun mapFromElectionAPIToDomainElection(electionAPIResponse: ElectionAPIModel): DomainElection {
        return DomainElection(
            electionAPIResponse.id,
            electionAPIResponse.name,
            electionAPIResponse.electionDay,
            electionAPIResponse.division
        )
    }

    fun mapFromApiNormalizedInputToDomainApiInput(normalizedInput: NormalizedInput): DomainNormalizedInput {
        return DomainNormalizedInput(
            normalizedInput.locationName,
            normalizedInput.line1,
            normalizedInput.line2,
            normalizedInput.line3,
            normalizedInput.city,
            normalizedInput.state,
            normalizedInput.zip
        )
    }

    fun mapToAPIPollingLocationsToDomainPollingLocations(pollingLocations: PollingLocations): DomainPollingLocations {
        return DomainPollingLocations(
            mapToDomainAddress(pollingLocations.address!!),
            pollingLocations.notes,
            pollingLocations.pollingHours,
            pollingLocations.name,
            pollingLocations.voterService,
            pollingLocations.startDate,
            pollingLocations.endDate,
            pollingLocations.latitude,
            pollingLocations.longitude
        )
    }

    fun mapFromAPIEarlyVoteSitesToDomainEarlyVoteSites(earlyVoteSites: EarlyVoteSites): DomainEarlyVoteSites  {
        return DomainEarlyVoteSites(
            mapToDomainAddress(earlyVoteSites.address!!),
            earlyVoteSites.notes,
            earlyVoteSites.voterServices,
            earlyVoteSites.startDate,
            earlyVoteSites.endDate,
            earlyVoteSites.latitude,
            earlyVoteSites.longitude,
            mapFromAPISourcesToDomainSources(earlyVoteSites.sources!!)
        )
    }

    fun mapFromAPISourcesToDomainSources(sources: Sources): DomainSources {
        return DomainSources(
            sources.name,
            sources.official)
    }

    fun mapFromAPIDropOffLocationsToDomainDropOffLocations(dropOffLocations: DropOffLocations): DomainDropOffLocations {
        return DomainDropOffLocations(
            mapToDomainAddress(dropOffLocations.address!!),
            dropOffLocations.notes,
            dropOffLocations.pollingHours,
            dropOffLocations.name,
            dropOffLocations.voterServices,
            dropOffLocations.startDate,
            dropOffLocations.endDate,
            dropOffLocations.latitude,
            dropOffLocations.longitude
        )
    }


}