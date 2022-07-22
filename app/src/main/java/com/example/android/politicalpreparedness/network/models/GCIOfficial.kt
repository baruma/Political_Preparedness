package com.example.android.politicalpreparedness.network.models

data class GCIOfficial (
    val name: String,
    val address: List<GCIAddress>? = null,
    val party: String? = null,
    val phones: List<String>? = null,
    val urls: List<String>? = null,
    val photoUrl: String? = null,
    val channels: List<GCIChannel>? = null
)
