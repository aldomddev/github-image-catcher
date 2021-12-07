package br.com.amd.githubimagecatcher.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.amd.githubimagecatcher.data.local.EmojiDao
import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity

@Database(
    entities = [EmojiEntity::class],
    exportSchema = true,
    version = 1
)
abstract class EmojisDatabase: RoomDatabase() {
    abstract fun getEmojiDao(): EmojiDao
}