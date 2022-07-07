package com.example.android.politicalpreparedness.network.models

data class Candidates (
    val name: String? = null,
    val party: String? = null,
    val candidateUrl: String? = null,
    val phone: String? = null,
    val photoUrl: String? = null,
    val email: String? = null,
    val orderOnBallot: Long? = null,
    // TODO: Name Channel appropriately - can't use plurals
    val channels: Channels? = null
)
