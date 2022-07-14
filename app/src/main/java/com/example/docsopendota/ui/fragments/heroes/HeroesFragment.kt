package com.example.docsopendota.ui.fragments.heroes

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.docsopendota.Either
import com.example.docsopendota.R
import com.example.docsopendota.databinding.FragmentHeroesBinding
import com.example.docsopendota.ui.adapters.HeroesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesFragment :
    Fragment(R.layout.fragment_heroes) {

    private val binding by viewBinding(FragmentHeroesBinding::bind)
    private val viewModel: HeroesViewModel by viewModels()
    private val heroesAdapter = HeroesAdapter(
        this::onItemClick
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
        setupObserves()
    }

    private fun setupRecyclerview() = with(binding.recyclerHeroes) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = heroesAdapter
    }

    private fun setupObserves() {
        viewModel.fetchHeroes().observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value)
                }
                is Either.Right -> {
                    Log.e("Arzymat", it.value.toString())
                    heroesAdapter.submitList(it.value)
                }
            }
        }
    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(
            HeroesFragmentDirections.actionHeroesFragmentToHeroesDetailFragment2(
                position = id
            )
        )
    }
}



