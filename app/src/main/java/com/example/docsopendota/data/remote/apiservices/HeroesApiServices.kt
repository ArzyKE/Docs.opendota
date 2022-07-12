package com.example.docsopendota.data.remote.apiservices

import com.example.docsopendota.models.DetailHeroModel
import com.example.docsopendota.models.DocsHeroesModel
import retrofit2.http.GET
import retrofit2.http.Path

interface HeroesApiServices {

    @GET("heroes")
    suspend fun fetchHeroes(): List<DocsHeroesModel>

    @GET("heroes/{hero_id}/matches")
    suspend fun fetchHeroesId(
        @Path("hero_id") id: Int
    ): List<DetailHeroModel>
}