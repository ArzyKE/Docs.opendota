package com.example.docsopendota.data.repositores

import androidx.lifecycle.liveData
import com.example.docsopendota.Either
import com.example.docsopendota.data.remote.apiservices.HeroesApiServices
import kotlinx.coroutines.Dispatchers
import java.io.IOException
import javax.inject.Inject

class HeroesRepository @Inject constructor(private val apiService: HeroesApiServices) {

    fun fetchHeroes() = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroes()))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
    fun fetchCharacterId(id: Int) = liveData(Dispatchers.IO) {
        try {
            emit(Either.Right(apiService.fetchHeroesId(id = id)))
        } catch (ioException: IOException) {
            emit(Either.Left(ioException.localizedMessage))
        }
    }
}