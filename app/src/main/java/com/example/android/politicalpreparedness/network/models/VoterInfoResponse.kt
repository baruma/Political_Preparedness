package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity
import com.squareup.moshi.JsonClass


// This was a custom class already made with relevant voter information.  Need to update this so it has all the Voter Info data.
@JsonClass(generateAdapter = true)
class VoterInfoResponse (
    val electionEntity: ElectionEntity,
    val pollingLocations: String? = null, //TODO: Future Use
    val contests: String? = null, //TODO: Future Use
    val state: List<State>? = null,
    val electionElectionOfficials: List<ElectionOfficial>? = null
)

/*
1. Flesh out api models
2. Call the second retrofit method


How can Polling Locations just be String?
 */