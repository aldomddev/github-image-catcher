package br.com.amd.githubimagecatcher.data.local

import androidx.room.*
import br.com.amd.githubimagecatcher.data.local.datasource.model.EmojiEntity

@Dao
interface EmojiDao {
    @Query("SELECT * FROM github_emojis")
    fun getEmojis(): List<EmojiEntity>

    @Query("SELECT * FROM github_emojis WHERE id = :id")
    fun getEmojiById(id: Int): EmojiEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOrUpdate(emoji: EmojiEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveOrUpdate(emojis: List<EmojiEntity>)
}