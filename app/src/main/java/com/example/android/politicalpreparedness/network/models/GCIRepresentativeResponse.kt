package com.example.android.politicalpreparedness.network.models

data class GCIRepresentativeResponse (
        val offices: List<GCIOffice>,
        val officials: List<GCIOfficial>
)