package br.com.amd.githubimagecatcher.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.amd.githubimagecatcher.data.local.dao.AvatarDao
import br.com.amd.githubimagecatcher.data.local.dao.EmojiDao
import br.com.amd.githubimagecatcher.data.local.datasource.model.AvatarEntity
import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity

@Database(
    entities = [
        EmojiEntity::class,
        AvatarEntity::class
    ],
    exportSchema = true,
    version = 1
)
abstract class ImageDatabase: RoomDatabase() {
    abstract fun getEmojiDao(): EmojiDao
    abstract fun getAvatarDao(): AvatarDao
}