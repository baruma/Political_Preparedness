package com.example.android.politicalpreparedness.network.jsonadapter

import com.example.android.politicalpreparedness.database.domainModels.DomainElection
import com.example.android.politicalpreparedness.network.models.Division
import com.example.android.politicalpreparedness.network.models.ElectionAPIModel
import com.example.android.politicalpreparedness.network.models.ElectionEntity
import com.example.android.politicalpreparedness.network.models.ElectionResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.Date
import java.text.SimpleDateFormat


class ElectionAdapter {
    @FromJson
    fun divisionFromJson (ocdDivisionId: String): Division {
        val countryDelimiter = "country:"
        val stateDelimiter = "state:"
        val country = ocdDivisionId.substringAfter(countryDelimiter,"")
                .substringBefore("/")
        val state = ocdDivisionId.substringAfter(stateDelimiter,"")
                .substringBefore("/")
        return Division(ocdDivisionId, country, state)
    }

    @ToJson
    fun divisionToJson (division: Division): String {
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

object Mapper {
    fun mapFromElectionResponseToDomainElection(APIPayload: ElectionResponse): List<DomainElection> {
        val electionEntities = APIPayload.electionEntities

        val domainElections = electionEntities.map { electionAPIModel ->
            DomainElection(
                electionAPIModel.id,
                electionAPIModel.name,
                electionAPIModel.electionDay as java.sql.Date,
                electionAPIModel.division
            )
        }

        return domainElections
    }
}

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

