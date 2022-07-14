package com.example.android.politicalpreparedness.database.domainModels

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DomainVoterInfoResult(
    val kind: String = "civicinfo#voterInfoResponse",
    val election: DomainElection,
    val otherElections: List<DomainElection> = emptyList(),
    val normalizedInput: DomainNormalizedInput,
    val pollingLocations: List<DomainPollingLocations> = emptyList(),
    val earlyVoteSites: List<DomainEarlyVoteSites> = emptyList(),
    val dropOffLocations: List<DomainDropOffLocations> = emptyList(),
    val contests: List<DomainContests> = emptyList(),
    val state: List<DomainState> = emptyList(),
    val electionElectionOfficials: List<DomainElectionOfficial> = emptyList(),
    val mailOnly: Boolean? = null
)

