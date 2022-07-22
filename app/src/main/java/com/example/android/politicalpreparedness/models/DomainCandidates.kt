package com.example.android.politicalpreparedness.models

data class DomainCandidates (
        val name: String? = null,
        val party: String? = null,
        val candidateUrl: String? = null,
        val phone: String? = null,
        val photoUrl: String? = null,
        val email: String? = null,
        val orderOnBallot: Long? = null,
        val channels: DomainChannel? = null
        )