package com.example.android.politicalpreparedness.models

data class DomainOffice(
    val name: String,
    val division: DomainDivision,
    val officials: List<Int>
)