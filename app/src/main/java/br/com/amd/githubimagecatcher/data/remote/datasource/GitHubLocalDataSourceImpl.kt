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

    override suspend fun getEmojiByName(name: String): Emoji {
        return emojiDao.getEmojiByName(name = name).toDomain()
    }

    override suspend fun saveOrUpdate(emoji: Emoji) {
        val namedEmoji = emojiDao.getEmojiByName(name = emoji.name)
        if (namedEmoji.id > 0) {
            emojiDao.saveOrUpdate(emoji = emoji.toDataEntity().copy(id = namedEmoji.id))
        } else {
            emojiDao.saveOrUpdate(emoji = emoji.toDataEntity())
        }
    }

    override suspend fun saveOrUpdate(emojis: List<Emoji>) {
        emojiDao.saveOrUpdate(emojis = emojis.toDataEntity())
    }
}