package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainElectionOfficial
import com.squareup.moshi.Json

data class GCIElectionOfficial (
    val name: String,
    val title: String,
    @Json(name="officePhoneNumber")
    val phone: String,
    @Json(name="faxNumber")
    val fax: String,
    val emailAddress: String
)

fun GCIElectionOfficial.toDomainModel(): DomainElectionOfficial {
    return DomainElectionOfficial(
        name, title, phone, fax, emailAddress
    )
}