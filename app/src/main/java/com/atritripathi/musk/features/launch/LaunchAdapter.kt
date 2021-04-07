package com.atritripathi.musk.features.launch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.atritripathi.musk.R
import com.atritripathi.musk.data.model.Launch
import com.atritripathi.musk.databinding.LaunchItemBinding
import com.atritripathi.musk.features.launch.LaunchAdapter.LaunchViewHolder

class LaunchAdapter : ListAdapter<Launch, LaunchViewHolder>(LAUNCH_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val binding = LaunchItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LaunchViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val currentLaunch = getItem(position)
        currentLaunch?.let { holder.bind(it) }
    }

    inner class LaunchViewHolder(private val binding: LaunchItemBinding) :
        ViewHolder(binding.root) {

        fun bind(launch: Launch) = with(binding) {
            tvLaunchName.text = launch.name
            tvLaunchDate.text = launch.formattedDate
            tvLaunchDetails.text = launch.details ?: "No launch details available."
            chipLaunchSuccess.apply {
                if (launch.success == true) {
                    isChecked = true
                    text = resources.getString(R.string.launch_success)
                } else {
                    isChecked = false
                    text = resources.getString(R.string.launch_failure)
                }
            }
        }
    }

    companion object {
        private val LAUNCH_COMPARATOR = object : DiffUtil.ItemCallback<Launch>() {
            override fun areItemsTheSame(oldItem: Launch, newItem: Launch) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Launch, newItem: Launch) =
                oldItem == newItem
        }
    }
}