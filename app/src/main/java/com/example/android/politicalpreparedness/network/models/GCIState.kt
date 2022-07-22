package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainAdministrationBody
import com.example.android.politicalpreparedness.models.DomainState

data class GCIState(
    val name: String,
    val electionAdministrationBody: GCIAdministrationBody
)

fun GCIState.toDomainModel(): DomainState {
    return DomainState (
        name,
        electionAdministrationBody.toDomainModel()
    )
}