package com.example.android.politicalpreparedness.network.models

import com.squareup.moshi.Json

data class GCIOffice (
    val name: String,
    val divisionId: String,
    @Json(name="officialIndices")
    val officials: List<Int>
) {

//    fun getRepresentatives(officials: List<Official>): List<Representative> {
//        return this.officials.map { index ->
////            Representative(officials[index], this)
//            Representative(division, officials[index], officials)
//        }
//    }
}
