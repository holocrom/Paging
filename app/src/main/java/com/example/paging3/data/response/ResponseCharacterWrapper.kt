package com.example.paging3.data.response

import com.google.gson.annotations.SerializedName

data class ResponseCharacterWrapper(
    @SerializedName("info") val information : InfoResponse,
    @SerializedName("results") val results : List<CharacterResponse>,
    )

data class ResponseLocationWrapper(
    @SerializedName("info") val information : InfoResponse,
    @SerializedName("results") val results : List<LocationResponse>,
)
