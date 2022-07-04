package com.example.android.politicalpreparedness.election

import com.example.android.politicalpreparedness.database.domainModels.DomainDivision
import com.example.android.politicalpreparedness.database.domainModels.DomainElection
import com.example.android.politicalpreparedness.network.entitymodels.DivisionEntity
import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity
import com.example.android.politicalpreparedness.network.models.ElectionResponse
import java.sql.Date

//fun ElectionEntity.asDomainModel(): DomainElection {
//    return DomainElection(
//        id = this.id,
//        name = this.name,
//        electionDay = this.electionDay,
//        division = this.
//    )
//}

fun DomainElection.asDatabaseModel(): ElectionEntity {
    //return AlarmEntity(id, wakeUpMethod, hoursOfSleep, days, vibration, sound )
    return ElectionEntity(
        id,
        name,
        electionDay,
        divisionId
    )
}

fun DomainDivision.toDatabaseModel() : DivisionEntity {
    return DivisionEntity(id, country!!, this.state!!)
}

fun convertElectionResponseToDomainElection(electionResponse: List<ElectionResponse>) {

}