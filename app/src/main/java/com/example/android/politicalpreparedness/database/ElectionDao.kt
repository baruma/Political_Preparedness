package com.example.android.politicalpreparedness.database

import androidx.room.*
import com.example.android.politicalpreparedness.database.DomainModels.DomainElection
import com.example.android.politicalpreparedness.network.models.Election

@Dao
interface ElectionDao {
    //DONE: Add insert query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElection(election: Election)

    //DONE: Add select all election query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElections(elections: List<Election>)

    //DONE: Add select single election query
    @Query("SELECT * FROM election_table ORDER BY id DESC")
    suspend fun getAllElections(): List<Election>

    //DONE: Add delete query
    @Delete
    suspend fun deleteElection(election: Election)

    //DONE: Add clear query
    @Delete
    suspend fun deleteElections(elections: List<Election>)

    // Amended functions that use Domain Models

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDomainElection(dElection: DomainElection)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDomainElections(dElections: List<DomainElection>)

    @Query("SELECT * FROM election_table ORDER BY id DESC")
    suspend fun getAllDomainElections(): List<DomainElection>

    @Delete
    suspend fun deleteDomainElection(dElection: Election)

    @Delete
    suspend fun deleteDOmainElections(dElections: List<DomainElection>)

}