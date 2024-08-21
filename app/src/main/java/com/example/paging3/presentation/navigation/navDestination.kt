package com.example.paging3.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home
@Serializable
data class Detail(
    val id: Int,
    val name : String,
    val status: String,
    val species : String,
    val gender : String,
    val image : String
)