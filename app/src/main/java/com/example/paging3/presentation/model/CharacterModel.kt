package com.example.paging3.presentation.model

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val isAlive: Boolean,
    val species: String,
    val gender: String,
    val image: String,
)

data class LocationModel(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val url: String,
    val created: String,
)
