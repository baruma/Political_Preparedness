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

/*
Confusion begins here.  The expected type is String but we're giving it a DomainState object.
We do need to give the database a string so it can grab stuff through relations.

 */
fun DomainDivision.toDatabaseModel() : DivisionEntity {
    // Type mismatch: inferred type is DomainState but String was expected
    return DivisionEntity(id, country!!, this.state!!.name)
}

fun convertElectionResponseToDomainElection(electionResponse: List<ElectionResponse>) {

}