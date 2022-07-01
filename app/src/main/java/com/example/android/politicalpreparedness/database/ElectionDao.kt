package com.example.android.politicalpreparedness.database

import androidx.room.*
import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity
import com.example.android.politicalpreparedness.network.entitymodels.entityRelationships.ElectionAndDivision

@Dao
interface ElectionDao {
    //DONE: Add insert query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElection(electionEntity: ElectionEntity)

    //DONE: Add select all election query
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertElections(electionEntities: List<ElectionEntity>)

    //DONE: Add select single election query
    @Query("SELECT * FROM election_table ORDER BY id DESC")
    suspend fun getAllElections(): List<ElectionEntity>

    @Transaction
    @Query("SELECT * FROM election_table")
    suspend fun getAllElectionAndDivisionRelations(): List<ElectionAndDivision>

    //DONE: Add delete query
    @Delete
    suspend fun deleteElection(electionEntity: ElectionEntity)

    //DONE: Add clear query
    @Delete
    suspend fun deleteElections(electionEntities: List<ElectionEntity>)

    // Amended functions that use Domain Models

//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertDomainElection(dElection: DomainElection)
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insertDomainElections(dElections: List<DomainElection>)
//
//    @Query("SELECT * FROM election_table ORDER BY id DESC")
//    suspend fun getAllDomainElections(): List<DomainElection>
//
//    @Delete
//    suspend fun deleteDomainElection(dElection: Election)
//
//    @Delete
//    suspend fun deleteDOmainElections(dElections: List<DomainElection>)

}