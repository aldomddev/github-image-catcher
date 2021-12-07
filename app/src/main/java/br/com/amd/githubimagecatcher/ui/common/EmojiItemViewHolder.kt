package br.com.amd.githubimagecatcher.ui.common

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import br.com.amd.githubimagecatcher.databinding.EmojiListItemBinding
import br.com.amd.githubimagecatcher.ui.model.EmojiVO
import coil.load

class EmojiItemViewHolder(
    private val binding: EmojiListItemBinding,
    val onItemClick: (EmojiVO) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private val context: Context get() = binding.root.context
    private lateinit var emoji: EmojiVO

    init {
        binding.ivEmoji.setOnClickListener {
            onItemClick(emoji)
        }
    }

    fun bind(emoji: EmojiVO) {
        this.emoji = emoji
        binding.ivEmoji.load(emoji.url)
    }
}