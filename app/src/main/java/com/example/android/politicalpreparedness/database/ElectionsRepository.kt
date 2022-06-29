package com.example.android.politicalpreparedness.database

import com.example.android.politicalpreparedness.database.domainModels.DomainElection
import com.example.android.politicalpreparedness.election.asDatabaseModel
import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity
import java.sql.Date

class ElectionsRepository(private val database: ElectionDatabase) {

    suspend fun saveElection(election: DomainElection) {
        val databaseElection = election.asDatabaseModel()
        return database.electionDao.insertElection(databaseElection)
    }

//    suspend fun saveElection(election: Election) {
//        return database.electionDao.insertElection(election)
//    }

    suspend fun saveElections(elections: List<DomainElection>) {
        val databaseElectionEntities = elections.map { domainElection ->
            ElectionEntity(
                domainElection.id,
                domainElection.name,
                domainElection.electionDay,
                domainElection.division.toString()
            )
        }
        return database.electionDao.insertElections(databaseElectionEntities)
    }

//    suspend fun saveElections(elections: List<Election>) {
//        return database.electionDao.insertElections(elections)
//    }

    suspend fun loadElections(databaseElectionEntities: List<ElectionEntity>): List<DomainElection> {
        val domainElections = databaseElectionEntities.map { databaseElection ->
            DomainElection(
                databaseElection.id,
                databaseElection.name,
                databaseElection.electionDay as Date,
                databaseElection.division
            )
        }
        return domainElections
//        return database.electionDao.getAllDomainElections()  // This is likely incorrect because how are you going to get domain models out of a database
    }

//    suspend fun loadElections(): List<Election> {
//        return database.electionDao.getAllElections()
//    }

    suspend fun deleteElection(election: DomainElection) {
        val databaseElection = election.asDatabaseModel()
        return database.electionDao.deleteElection(databaseElection)
    }

//    suspend fun deleteElection(election: Election) {
//        return database.electionDao.deleteElection(election)
//    }

    // Hold on.  We are trying to take Domain Models and delete their Database Model equivalent
    suspend fun deleteElections(elections: List<DomainElection>) {
        val databaseElectionEntities = elections.map { domainElection ->
            ElectionEntity(
                domainElection.id,
                domainElection.name,
                domainElection.electionDay,
                domainElection.division
            )
        }
        return database.electionDao.deleteElections(databaseElectionEntities)
    }

}