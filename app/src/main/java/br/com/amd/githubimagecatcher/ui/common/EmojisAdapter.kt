package br.com.amd.githubimagecatcher.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import br.com.amd.githubimagecatcher.databinding.EmojiListItemBinding
import br.com.amd.githubimagecatcher.ui.model.EmojiVO

class EmojisAdapter : ListAdapter<EmojiVO, EmojiItemViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmojiItemViewHolder {
        val binding =
            EmojiListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmojiItemViewHolder(binding, ::removeItemFromList)
    }

    override fun onBindViewHolder(holder: EmojiItemViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private fun removeItemFromList(item: EmojiVO) {
        val listItems = currentList.toMutableList()
        listItems.remove(item)
        submitList(listItems)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<EmojiVO>() {
            override fun areItemsTheSame(oldItem: EmojiVO, newItem: EmojiVO): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: EmojiVO, newItem: EmojiVO): Boolean {
                return areItemsTheSame(oldItem, newItem)
            }
        }
    }
}