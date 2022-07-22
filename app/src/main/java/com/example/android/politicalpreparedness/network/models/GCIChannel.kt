package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainChannel

data class GCIChannel (
    val type: String,
    val id: String
)

fun GCIChannel.toDomainModel(): DomainChannel {
    return DomainChannel(type, id)
}