package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.network.apimodels.ElectionAPIModel
import com.squareup.moshi.JsonClass


// This was a custom class already made with relevant voter information.  Need to update this so it has all the Voter Info data.
@JsonClass(generateAdapter = true)
data class VoterInfoResponse (
    val kind: String = "civicinfo#voterInfoResponse",
    val election: ElectionAPIModel,  // TODO: definitely revisit this
    val otherElections: Array<ElectionAPIModel> = emptyArray(),  // TODO: Revisit this, too
    val normalizedInput: NormalizedInput,
//    val electionEntity: ElectionEntity,  // Might have to remove this = ask John
    val pollingLocations: Array<PollingLocations> = emptyArray(),
    val earlyVoteSites: Array<EarlyVoteSites> = emptyArray(),
    val dropOffLocation: Array<DropOffLocations> = emptyArray(),
    val contests: Array<Contests> = emptyArray(),
    val state: Array<State> = emptyArray(),
    val electionElectionOfficials: Array<ElectionOfficial>? = emptyArray(),
    val mailOnly: Boolean? = null
)