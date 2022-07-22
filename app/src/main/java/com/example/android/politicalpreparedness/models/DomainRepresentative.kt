package com.example.android.politicalpreparedness.models

data class DomainRepresentative(
    val divisions: DomainDivision?,
    val official: List<DomainOfficial>,
    val office: List<DomainOffice>
    )
