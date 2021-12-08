package br.com.amd.githubimagecatcher.data.local.dao

import androidx.room.*
import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity

@Dao
interface EmojiDao {
    @Query("SELECT * FROM emoji")
    fun getEmojis(): List<EmojiEntity>

    @Query("SELECT * FROM emoji WHERE id = :id")
    fun getEmojiById(id: Int): EmojiEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEmoji(emoji: EmojiEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveEmojis(emojis: List<EmojiEntity>)
}