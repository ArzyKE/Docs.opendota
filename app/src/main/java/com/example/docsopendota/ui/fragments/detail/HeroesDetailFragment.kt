package com.example.docsopendota.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.docsopendota.Either
import com.example.docsopendota.R
import com.example.docsopendota.databinding.FragmentHeroesDetailBinding
import com.example.docsopendota.ui.adapters.DetailHeroesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HeroesDetailFragment : Fragment(R.layout.fragment_heroes_detail) {

    private val viewBinding by viewBinding(FragmentHeroesDetailBinding::bind)
    private val viewModel: HeroesDetailViewModel by viewModels()
    private val args by navArgs<HeroesDetailFragmentArgs>()
    private val detailHeroesAdapter = DetailHeroesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerview()
        getData()
    }

    private fun initRecyclerview() = with(viewBinding.detailHeroesRecview) {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = detailHeroesAdapter
    }

    private fun getData() {
        viewModel.fetchHeroesId(args.position).observe(viewLifecycleOwner) {
            when (it) {
                is Either.Left -> {
                    Log.e("anime", it.value.toString())
                }
                is Either.Right -> {
                    detailHeroesAdapter.submitList(it.value)
                }
            }
        }
    }
}

