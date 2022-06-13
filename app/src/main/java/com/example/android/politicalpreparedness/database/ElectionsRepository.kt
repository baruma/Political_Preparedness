package com.example.android.politicalpreparedness.database

import com.example.android.politicalpreparedness.network.models.Election

class ElectionsRepository(private val database: ElectionDatabase) {
    suspend fun saveElection(election: Election) {
        return database.electionDao.insertElection(election)
    }

    suspend fun saveElections(elections: List<Election>) {
        return database.electionDao.insertElections(elections)
    }

    suspend fun loadElections(): List<Election> {
        return database.electionDao.getAllElections()
    }

    suspend fun deleteElection(election: Election) {
        return database.electionDao.deleteElection(election)
    }

    suspend fun deleteElections(elections: List<Election>) {
        return database.electionDao.deleteElections(elections)
    }

}