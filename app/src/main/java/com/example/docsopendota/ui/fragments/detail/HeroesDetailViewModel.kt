package com.example.docsopendota.ui.fragments.detail

import androidx.lifecycle.ViewModel
import com.example.docsopendota.data.repository.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesDetailViewModel @Inject constructor(private val repository: HeroesRepository) :
    ViewModel() {

    fun fetchHeroesId(position: Int) = repository.fetchCharacterId(position)
}