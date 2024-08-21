package com.example.paging3.data

import com.example.paging3.data.response.ResponseCharacterWrapper
import com.example.paging3.data.response.ResponseLocationWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {
    @GET("/api/character/")
    suspend fun getCharacters(@Query("page") page : Int) : ResponseCharacterWrapper

    @GET("/api/location/")
    suspend fun getLocations(@Query("page") page : Int) : ResponseLocationWrapper
}