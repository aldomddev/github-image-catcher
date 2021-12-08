package br.com.amd.githubimagecatcher.data.remote.datasource

import br.com.amd.githubimagecatcher.data.local.dao.AvatarDao
import br.com.amd.githubimagecatcher.data.local.dao.EmojiDao
import br.com.amd.githubimagecatcher.data.mappers.toAvatarEntity
import br.com.amd.githubimagecatcher.data.mappers.toEmojiEntity
import br.com.amd.githubimagecatcher.data.mappers.toDomain
import br.com.amd.githubimagecatcher.domain.model.Image
import br.com.amd.githubimagecatcher.domain.repository.GitHubLocalDataSource
import javax.inject.Inject

class GitHubLocalDataSourceImpl @Inject constructor(
    private val emojiDao: EmojiDao,
    private val avatarDao: AvatarDao
) : GitHubLocalDataSource {

    override suspend fun getEmojis(): List<Image> {
        return emojiDao.getEmojis().toDomain()
    }

    override suspend fun getEmojiById(id: Int): Image {
        return emojiDao.getEmojiById(id = id).toDomain()
    }

    override suspend fun saveEmoji(emoji: Image) {
        emojiDao.saveEmoji(emoji = emoji.toEmojiEntity())
    }

    override suspend fun saveEmojis(emojis: List<Image>) {
        emojiDao.saveEmojis(emojis = emojis.toEmojiEntity())
    }

    override suspend fun getAvatar(username: String): Image {
        return avatarDao.getAvatar(username = username)
    }

    override suspend fun saveAvatar(avatar: Image) {
        avatarDao.saveAvatar(avatar = avatar.toAvatarEntity())
    }

    override suspend fun deleteAvatar(avatar: Image) {
        avatarDao.deleteAvatar(avatar = avatar.toAvatarEntity())
    }
}