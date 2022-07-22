package com.example.android.politicalpreparedness.database

import com.example.android.politicalpreparedness.models.DomainElection
import com.example.android.politicalpreparedness.election.asDatabaseModel
import com.example.android.politicalpreparedness.database.entitymodels.ElectionEntity

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
                domainElection.divisionId
            )
        }
        return database.electionDao.insertElections(databaseElectionEntities)
    }



//    suspend fun saveElections(elections: List<Election>) {
//        return database.electionDao.insertElections(elections)
//    }

    suspend fun loadElections(): List<DomainElection> {
        database.electionDao.getAllElections()
//        val domainElections = databaseElectionEntities.map { electionAndDivision ->
//            ElectionAndDivision(
//                elec
//            )
//        }
//
//        return database.electionDao.getAllDomainElections()  // This is likely incorrect because how are you going to get domain models out of a database
        return emptyList()
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
                domainElection.divisionId
            )
        }
        return database.electionDao.deleteElections(databaseElectionEntities)
    }

}