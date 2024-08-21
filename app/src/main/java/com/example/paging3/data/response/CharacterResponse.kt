package com.example.paging3.data.response

import com.example.paging3.presentation.model.CharacterModel
import com.example.paging3.presentation.model.LocationModel
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
    @SerializedName("image") val image: String,
){
    fun toPresentation(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            status = status,
            species = species,
            gender = gender,
            image = image,
            isAlive = status == "Alive",

        )
    }
}

data class LocationResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("type") val type: String,
    @SerializedName("dimension") val dimension: String,
    @SerializedName("url") val url: String,
    @SerializedName("created") val created: String,
){
    fun toPresentationLocation(): LocationModel {
        return LocationModel(
            id = id,
            name = name,
            type = type,
            //residents = residents,
            dimension = dimension,
            url = url,
            created = created,
            )
    }
}
