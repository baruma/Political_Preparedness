package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainContests
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCIContests (
    val type: String? = null,
    val primaryParty: String? = null,
    val electorateSpecifications: String? = null,
    val special: String? = null,
    val ballotTitle: String? = null,
    val office: String? = null,
    var level: Array<String> = emptyArray(),
    var roles: Array<String> = emptyArray(),
    val district: GCIDistrict? = null,
    val numberElected: Long? = null,
    val numberVotingFor: Long? = null,
    val ballotPlacement: Long? = null,
    val candidate: GCICandidates? = null,
    val referendumTitle: String? = null,
    val referendumSubtitle: String? = null,
    val referendumUrl: String? = null,
    val referendumText: String? = null,
    val referendumProStatement: String? = null,
    val referendumConStatement: String? = null,
    val referendumPassageThreshold: String? = null,
    val referendumEffectOfAbstain: String? = null,
    val referendumBallotResponse: Array<String> = emptyArray(),
    val sources: GCISources
)

// TODO Come back here
//fun GCIContests.toDomainModel(): DomainContests {
//    return DomainContests(
//        type,
//        primaryParty,
//        electorateSpecifications,
//        special,
//        ballotTitle,
//        office,
//        level,
//        roles,
//        district,
//        numberElected,
//        numberVotingFor,
//        ballotPlacement,
//        candidate,
//        referendumTitle,
//        referendumSubtitle,
//        referendumUrl,
//        referendumText,
//        referendumProStatement,
//        referendumConStatement,
//        referendumPassageThreshold,
//        referendumEffectOfAbstain,
//        referendumBallotResponse,
//        sources
//    )
//}