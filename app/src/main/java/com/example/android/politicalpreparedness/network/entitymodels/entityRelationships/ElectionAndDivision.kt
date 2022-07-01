package com.example.android.politicalpreparedness.network.entitymodels.entityRelationships

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.android.politicalpreparedness.network.entitymodels.DivisionEntity
import com.example.android.politicalpreparedness.network.entitymodels.ElectionEntity

data class ElectionAndDivision (
    @Embedded val election: ElectionEntity,
    @Relation(parentColumn = "id", entityColumn= "id") val division: DivisionEntity?
    )