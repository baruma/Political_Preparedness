package com.example.android.politicalpreparedness.network.mapper

import com.example.android.politicalpreparedness.models.*
import com.example.android.politicalpreparedness.network.apimodels.ElectionAPIModel
import com.example.android.politicalpreparedness.network.apimodels.toDomainModel
import com.example.android.politicalpreparedness.network.models.*
import com.example.android.politicalpreparedness.network.models.GCIVoterInfoResponse
import com.example.android.politicalpreparedness.representative.model.Representative

/*
TODO: Need to clean up this file and document it better. Hard to traverse.
 */

/*
This file is pretty hard to read.  There's a lot of bubbling up and bubbling down everywhere.  It is hard to say that
this will be a portfolio piece later with how much refactoring will go into it, but I think there's value
in learning how to deal with gross code and making it pretty.
 */

// This pattern you see below where nested models map other nested models is called Cascading.
object ApiToDomainMapper {

    /* MAPPING ELECTION DATA MAPS */

    fun mapFromGCIAddressToAddress(apiAddress: GCIAddress): DomainAddress {
        return apiAddress.toDomainModel()
    }

    fun mapFromGCAAdministrationBodyToAdministrationBody(apiAdministrationBody: GCIAdministrationBody): DomainAdministrationBody {
        return apiAdministrationBody.toDomainModel()
    }

    fun mapFromGCIStateToState(apiState: GCIState): DomainState {
        return DomainState(
            apiState.name,
            mapFromGCAAdministrationBodyToAdministrationBody(apiState.electionAdministrationBody!!)
        )
    }

    fun mapFromAPIDivisionToDomainDivision(apiDivision: GCIDivision, apistate: GCIState): DomainDivision {
        return DomainDivision(
            apiDivision.id,
            apiDivision.country,
            mapFromAPIStateToDomainState(apistate, apistate.electionAdministrationBody))
    }

    fun mapFromCGIElectionResponseToElection(APIPayload: GCIElectionResponse): List<DomainElection> {
        val electionEntities = APIPayload.elections

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

    fun mapFromAdministrationAPIResponseToDomainAdminisstration(administrationAPIResponse: GCIAdministrationBody): DomainAdministrationBody {
        return administrationAPIResponse.toDomainModel()
    }

//    fun mapFromStateResponseToDomainState(domainAdministration: DomainAdministrationBody, stateName: String): DomainState {
//        return DomainState(stateName, domainAdministration)
//    }

    /* VOTER INFO RESPONSE MAPS */

    fun mapFromAPIVoterInfoResponseToDomainVoterInfoResponse(voterInfoResponse: GCIVoterInfoResponse): DomainVoterInfoResult {
//        voterInfoResponse.?
        return DomainVoterInfoResult(
            voterInfoResponse.kind,
            mapFromElectionAPIToDomainElection(voterInfoResponse.election),
            voterInfoResponse.otherElections.map { mapFromElectionAPIToDomainElection(it) },
            mapFromApiNormalizedInputToDomainApiInput(voterInfoResponse.normalizedInput),
            voterInfoResponse.pollingLocations.map { mapToAPIPollingLocationsToDomainPollingLocations(it) },
            voterInfoResponse.earlyVoteSites.map { mapFromAPIEarlyVoteSitesToDomainEarlyVoteSites(it) },
            voterInfoResponse.dropOffLocation.map { mapFromAPIDropOffLocationsToDomainDropOffLocations(it) },
            voterInfoResponse.contests.map { mapFromAPIContestToDomainContests(it) },
            voterInfoResponse.state.map { state -> mapFromAPIStateToDomainState(state, state.electionAdministrationBody) },
            voterInfoResponse.electionElectionOfficials!!.map { mapFromAPIElectionOfficialsToDomainElectionOfficials(it) },
            voterInfoResponse.mailOnly
        )
    }

    fun mapFromAPIElectionOfficialsToDomainElectionOfficials(electionOfficial: GCIElectionOfficial): DomainElectionOfficial {
        return electionOfficial.toDomainModel()
    }

    fun mapFromAPIContestToDomainContests(contests: GCIContests): DomainContests {
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

    fun mapFromAPICandidatesToDomainCandidates(candidates: GCICandidates): DomainCandidates {
        return candidates.toDomainModel()
    }

    fun mapFromAPIChannelsToDomainChannels(channels: GCIChannel): DomainChannel {
        return channels.toDomainModel()
    }

    fun mapAPIDistrictsToDomainDistricts(district: GCIDistrict): DomainDistrict {
        return district.toDomainModel()
    }

    fun mapFromAPIStateToDomainState(state: GCIState, administrationBody: GCIAdministrationBody): DomainState {
        return state.toDomainModel()
    }

    fun mapFromElectionAPIToDomainElection(electionAPIResponse: ElectionAPIModel): DomainElection {
        return electionAPIResponse.toDomainModel()
    }

    fun mapFromApiNormalizedInputToDomainApiInput(normalizedInput: GCINormalizedInput): DomainNormalizedInput {
        return normalizedInput.toDomainModel()
    }

    // TODO: Come back here
    fun mapToAPIPollingLocationsToDomainPollingLocations(pollingLocations: GCIPollingLocations): DomainPollingLocations {
        return DomainPollingLocations(
            pollingLocations.address!!.toDomainModel(),
            pollingLocations.notes,
            pollingLocations.pollingHours,
            pollingLocations.name,
            pollingLocations.voterService,
            pollingLocations.startDate,
            pollingLocations.endDate,
            pollingLocations.latitude,
            pollingLocations.longitude,
            pollingLocations.sources!!.toDomainModel()
        )
    }

    fun mapFromAPIEarlyVoteSitesToDomainEarlyVoteSites(earlyVoteSites: GCIEarlyVoteSites): DomainEarlyVoteSites  {
        return DomainEarlyVoteSites(
            (earlyVoteSites.address!!.toDomainModel()),
            earlyVoteSites.notes,
            earlyVoteSites.voterServices,
            earlyVoteSites.startDate,
            earlyVoteSites.endDate,
            earlyVoteSites.latitude,
            earlyVoteSites.longitude,
            mapFromAPISourcesToDomainSources(earlyVoteSites.sources!!)
        )
    }

    fun mapFromAPISourcesToDomainSources(sources: GCISources): DomainSources {
        return sources.toDomainModel()
    }

    fun mapFromAPIDropOffLocationsToDomainDropOffLocations(dropOffLocations: GCIDropOffLocations): DomainDropOffLocations {
        return DomainDropOffLocations(
            (dropOffLocations.address!!.toDomainModel()),
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

    fun mapFromAPIToDomainOfficials(official: GCIOfficial): DomainOfficial {
        return DomainOfficial(
            official.name,
            // TODO: wtf does this want?
            official.address!!.toListOfDomainModel(),
            official.party!!,
            official.phones!!,
            official.urls!!,
            official.photoUrl!!,
            official.channels!!.map { mapFromAPIChannelsToDomainChannels(it) }
        )
    }

    /* REPRESENTATIVE MAPS */

    fun mapFromAPIOfficeToDomainOffice(office: GCIOffice, state: GCIState): DomainOffice {
        return DomainOffice(
            office.name,
            mapFromAPIDivisionToDomainDivision(GCIDivision(""), state), //TODO
            office.officials
        )
    }

    fun mapFromAPIAddressToDomainAddress(address: GCIAddress): DomainAddress {
        return address.toDomainModel()
    }

    fun mapFromAPIRepresentativeToDomainRepresentative(representative: Representative, state: GCIState): DomainRepresentative {
        val division = mapFromAPIDivisionToDomainDivision(representative.divisions!!, state)
        val unmappedOfficials = representative.official
        val officials = unmappedOfficials.map { mapFromAPIToDomainOfficials(it) }
        val offices = listOf<DomainOffice>()

        return DomainRepresentative(division, officials, offices)
    }

}