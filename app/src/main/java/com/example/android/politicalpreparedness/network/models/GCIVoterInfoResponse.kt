package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.network.apimodels.ElectionAPIModel
import com.squareup.moshi.JsonClass


// This was a custom class already made with relevant voter information.  Need to update this so it has all the Voter Info data.
@JsonClass(generateAdapter = true)
data class GCIVoterInfoResponse (
    val kind: String = "civicinfo#voterInfoResponse",
    val election: ElectionAPIModel,  // TODO: definitely revisit this
    val otherElections: Array<ElectionAPIModel> = emptyArray(),  // TODO: Revisit this, too
    val normalizedInput: GCINormalizedInput,
//    val electionEntity: ElectionEntity,  // Might have to remove this = ask John
    val pollingLocations: Array<GCIPollingLocations> = emptyArray(),
    val earlyVoteSites: Array<GCIEarlyVoteSites> = emptyArray(),
    val dropOffLocation: Array<GCIDropOffLocations> = emptyArray(),
    val contests: Array<GCIContests> = emptyArray(),
    val state: List<GCIState> = emptyList<GCIState>(),
    val electionElectionOfficials: Array<GCIElectionOfficial>? = emptyArray(),
    val mailOnly: Boolean? = null
)