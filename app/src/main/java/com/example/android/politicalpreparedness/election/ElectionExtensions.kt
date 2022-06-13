package com.example.android.politicalpreparedness.election

import com.example.android.politicalpreparedness.database.DomainModels.DomainElection
import com.example.android.politicalpreparedness.network.models.Election
import java.sql.Date

fun Election.asDomainModel(): DomainElection {
    return DomainElection(
        id = this.id,
        name = this.name,
        electionDay = this.electionDay as Date,
        division = this.division
    )
}

fun DomainElection.asDatabaseModel(): Election {
    //return AlarmEntity(id, wakeUpMethod, hoursOfSleep, days, vibration, sound )
    return Election(
        id,
        name,
        electionDay,
        division
    )
}
