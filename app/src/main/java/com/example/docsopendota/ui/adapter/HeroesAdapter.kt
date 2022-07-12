package com.example.docsopendota.ui.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.docsopendota.databinding.ItemHeroesBinding
import com.example.docsopendota.models.DocsHeroesModel
import java.util.*
import kotlin.reflect.KFunction1

class HeroesAdapter(private val itemClick: KFunction1<Int, Unit>
) : androidx.recyclerview.widget.ListAdapter<DocsHeroesModel, HeroesAdapter.ViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHeroesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemHeroesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: DocsHeroesModel) {
            binding.itemHeroesName.text = item.name

            binding.root.setOnClickListener {
                itemClick(item.id)
            }
        }
    }

    companion object {

        private val diffCallback: DiffUtil.ItemCallback<DocsHeroesModel> =
            object : DiffUtil.ItemCallback<DocsHeroesModel>() {
                override fun areItemsTheSame(
                    oldItem: DocsHeroesModel,
                    newItem: DocsHeroesModel
                ): Boolean {
                    return oldItem.id === newItem.id
                }

                @SuppressLint("DiffUtilEquals")
                override fun areContentsTheSame(
                    oldItem: DocsHeroesModel,
                    newItem:DocsHeroesModel
                ): Boolean {
                    return oldItem === newItem
                }
            }
    }
}
