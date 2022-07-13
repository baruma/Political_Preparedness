package com.example.android.politicalpreparedness.database.domainModels

import com.example.android.politicalpreparedness.network.models.Candidates
import com.example.android.politicalpreparedness.network.models.District
import com.example.android.politicalpreparedness.network.models.Sources

data class DomainContests (
        val type: String? = null,
        val primaryParty: String? = null,
        val electorateSpecifications: String? = null,
        val special: String? = null,
        val ballotTitle: String? = null,
        val office: String? = null,
        var level: Array<String> = emptyArray(),
        var roles: Array<String> = emptyArray(),
        val district: DomainDistrict? = null,
        val numberElected: Long? = null,
        val numberVotingFor: Long? = null,
        val ballotPlacement: Long? = null,
        val candidate: DomainCandidates? = null,
        val referendumTitle: String? = null,
        val referendumSubtitle: String? = null,
        val referendumUrl: String? = null,
        val referendumText: String? = null,
        val referendumProStatement: String? = null,
        val referendumConStatement: String? = null,
        val referendumPassageThreshold: String? = null,
        val referendumEffectOfAbstain: String? = null,
        val referendumBallotResponse: Array<String> = emptyArray(),
        val sources: DomainSources
        )