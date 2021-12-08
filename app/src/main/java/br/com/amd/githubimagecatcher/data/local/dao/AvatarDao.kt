package br.com.amd.githubimagecatcher.data.local.dao

import androidx.room.*
import br.com.amd.githubimagecatcher.data.local.datasource.model.AvatarEntity
import br.com.amd.githubimagecatcher.domain.model.Image

@Dao
interface AvatarDao {
    @Query("SELECT * FROM avatar WHERE name LIKE :username")
    fun getAvatar(username: String): Image

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAvatar(avatar: AvatarEntity)

    @Delete
    fun deleteAvatar(avatar: AvatarEntity)
}