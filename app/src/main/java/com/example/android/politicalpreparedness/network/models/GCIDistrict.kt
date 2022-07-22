package com.example.android.politicalpreparedness.network.models

import com.example.android.politicalpreparedness.models.DomainDistrict
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GCIDistrict (
        val name: String? = null,
        val scope: String? = null,
        val id: String? = null
)

fun GCIDistrict.toDomainModel(): DomainDistrict{
        return DomainDistrict(name, scope, id)
}