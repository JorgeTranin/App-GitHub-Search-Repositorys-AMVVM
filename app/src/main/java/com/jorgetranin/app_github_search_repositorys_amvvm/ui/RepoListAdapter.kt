package com.jorgetranin.app_github_search_repositorys_amvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jorgetranin.app_github_search_repositorys_amvvm.data.model.Repository
import com.jorgetranin.app_github_search_repositorys_amvvm.databinding.ItemReposBinding


class RepoListAdapter : ListAdapter<Repository, RepoListAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemReposBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemReposBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repository) {
            binding.tvRepoName.text = item.name
            binding.tvRepoDescription.text = item.description
            binding.tvRepoLanguage.text = item.language
            binding.chipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Repository>() {
    override fun areItemsTheSame(oldItem: Repository, newItem: Repository) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Repository, newItem: Repository) =
        oldItem.id == newItem.id
}