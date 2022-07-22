package com.example.android.politicalpreparedness.network.jsonadapter

import com.example.android.politicalpreparedness.network.models.GCIDivision
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.text.SimpleDateFormat
import java.util.*


class ElectionAdapter {
    @FromJson
    fun divisionFromJson (ocdDivisionId: String): GCIDivision {
        val countryDelimiter = "country:"
        val stateDelimiter = "state:"
        val country = ocdDivisionId.substringAfter(countryDelimiter,"")
                .substringBefore("/")
        val state = ocdDivisionId.substringAfter(stateDelimiter,"")
                .substringBefore("/")
        return GCIDivision(ocdDivisionId, country, state)
    }

    @ToJson
    fun divisionToJson (division: GCIDivision): String {
        return division.id
    }
}

class DateAdapter {
    @FromJson
    fun convertStringToDate(stringDate: String): Date {
        val firstApiFormat = SimpleDateFormat("yyyy-MM-dd")
        return firstApiFormat.parse(stringDate)!!


//        val defaultZoneId: ZoneId = ZoneId.systemDefault()
//
//        val localDate = LocalDate.parse(stringDate, firstApiFormat)
//
//        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()) as Date
    }

    @ToJson
    fun dateToString(date: Date): String {
        val firstApiFormat = SimpleDateFormat("yyyy-MM-dd")
        return firstApiFormat.format(date)
    }
}

//fun AdministrationBody.toDomainModel(): DomainAdministration {
//    return DomainAdministration("", "", "", "", Address("", "", "", "", ""))
//}
//
//fun blah() {
//    var admin: AdministrationBody
//    var adminDOmainModel = admin!!.toDomainModel()
//}

//    suspend fun deleteElections(elections: List<DomainElection>) {
//        val databaseElections = elections.map { domainElection ->
//            Election(
//                domainElection.id,
//                domainElection.name,
//                domainElection.electionDay,
//                domainElection.division
//            )
//        }
//        return database.electionDao.deleteElections(databaseElections)
//    }

