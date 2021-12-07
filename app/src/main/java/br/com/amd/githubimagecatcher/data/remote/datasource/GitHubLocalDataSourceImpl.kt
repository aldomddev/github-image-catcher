package br.com.amd.githubimagecatcher.data.remote.datasource

import br.com.amd.githubimagecatcher.data.local.EmojiDao
import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity
import br.com.amd.githubimagecatcher.data.mappers.toDataEntity
import br.com.amd.githubimagecatcher.data.mappers.toDomain
import br.com.amd.githubimagecatcher.domain.model.Emoji
import br.com.amd.githubimagecatcher.domain.repository.GitHubLocalDataSource
import javax.inject.Inject

class GitHubLocalDataSourceImpl @Inject constructor(
    private val emojiDao: EmojiDao
) : GitHubLocalDataSource {
    override suspend fun getEmojis(): List<Emoji> {
        return emojiDao.getEmojis().toDomain()
    }

    override suspend fun getEmojiById(id: Int): Emoji {
        return emojiDao.getEmojiById(id = id).toDomain()
    }

    override suspend fun saveOrUpdate(emoji: Emoji) {
        emojiDao.saveOrUpdate(emoji = emoji.toDataEntity())
    }

    override suspend fun saveOrUpdate(emojis: List<Emoji>) {
        emojiDao.saveOrUpdate(emojis = emojis.toDataEntity())
    }
}