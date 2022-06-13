package com.example.android.politicalpreparedness.network.jsonadapter

import com.example.android.politicalpreparedness.network.models.Division
import com.example.android.politicalpreparedness.network.models.Election
import com.example.android.politicalpreparedness.network.models.ElectionResponse
import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import java.util.Date
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter


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
    fun map(electionFromAPI: ElectionResponse): List<Election> {
       return electionFromAPI.elections
    }

}