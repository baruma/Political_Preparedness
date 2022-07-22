package com.example.android.politicalpreparedness.database.entitymodels.entityRelationships

import androidx.room.Embedded
import androidx.room.Relation
import com.example.android.politicalpreparedness.database.entitymodels.DivisionEntity
import com.example.android.politicalpreparedness.database.entitymodels.ElectionEntity

data class ElectionAndDivision (
    @Embedded val election: ElectionEntity,
    @Relation(parentColumn = "id", entityColumn= "id") val division: DivisionEntity?
    )