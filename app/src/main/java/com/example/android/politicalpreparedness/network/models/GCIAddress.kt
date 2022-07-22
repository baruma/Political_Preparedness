package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainAddress
import com.example.android.politicalpreparedness.models.DomainElection

data class GCIAddress(
    val locationName: String = "",
    val line1: String = "",
    val line2: String = "",
    val city: String = "",
    val state: String = "",
    val zip: String = ""
) {
    fun toFormattedString(): String {
        var output = line1.plus("\n")
        if (!line2.isNullOrEmpty()) output = output.plus(line2).plus("\n")
        output = output.plus("$city, $state $zip")
        return output
    }
}

fun GCIAddress.toDomainModel(): DomainAddress {
    return DomainAddress(
        line1,
        line2,
        city,
        state,
        zip
    )
}

// TODO: FIX THIS.  Need to create an extension that resolves list of addresses.
fun List<GCIAddress>.toListOfDomainModel(): List<DomainAddress> {
    return map {
        it.toDomainModel()
    }
}