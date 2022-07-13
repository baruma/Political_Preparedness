package com.example.android.politicalpreparedness.database.domainModels

import com.squareup.moshi.Json

data class DomainElectionOfficial(
    val name: String,
    val title: String,
    @Json(name = "officePhoneNumber")
    val phone: String,
    @Json(name = "faxNumber")
    val fax: String,
    val emailAddress: String
)