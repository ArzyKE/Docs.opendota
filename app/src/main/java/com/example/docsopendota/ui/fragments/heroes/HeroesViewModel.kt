package com.example.docsopendota.ui.fragments.heroes

import androidx.lifecycle.ViewModel
import com.example.docsopendota.data.repository.HeroesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(private val repository: HeroesRepository) :
    ViewModel() {

    fun fetchHeroes() = repository.fetchHeroes()
}
