package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainCandidates

data class GCICandidates (
    val name: String? = null,
    val party: String? = null,
    val candidateUrl: String? = null,
    val phone: String? = null,
    val photoUrl: String? = null,
    val email: String? = null,
    val orderOnBallot: Long? = null,
    val channels: GCIChannel? = null
)

fun GCICandidates.toDomainModel(): DomainCandidates {
    return DomainCandidates(
        name,
        party,
        candidateUrl,
        phone,
        photoUrl,
        email,
        orderOnBallot,
        channels!!.toDomainModel()
    )
}