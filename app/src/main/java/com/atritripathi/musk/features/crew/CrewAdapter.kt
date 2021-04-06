package com.atritripathi.musk.features.crew

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.atritripathi.musk.R
import com.atritripathi.musk.data.model.Crew
import com.atritripathi.musk.databinding.CrewItemBinding
import com.atritripathi.musk.features.crew.CrewAdapter.CrewViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

class CrewAdapter(private val listener: OnCrewClickListener) :
    ListAdapter<Crew, CrewViewHolder>(CREW_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val binding = CrewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CrewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
        val currentCrew = getItem(position)
        currentCrew?.let { holder.bind(it) }
    }

    inner class CrewViewHolder(private val binding: CrewItemBinding) : ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = getItem(position)
                    item?.let { listener.onClick(it) }
                }
            }
        }

        fun bind(crew: Crew) {
            with(binding) {
                Glide.with(itemView)
                    .load(crew.image)
                    .centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .error(R.drawable.ic_error)
                    .into(binding.ivCrew)
                tvCrewName.text = crew.name
            }
        }
    }

    interface OnCrewClickListener {
        fun onClick(crew: Crew)
    }

    companion object {
        private val CREW_COMPARATOR = object : DiffUtil.ItemCallback<Crew>() {
            override fun areItemsTheSame(oldItem: Crew, newItem: Crew) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Crew, newItem: Crew) =
                oldItem == newItem
        }
    }
}