package br.com.amd.githubimagecatcher.di

import android.content.Context
import androidx.room.Room
import br.com.amd.githubimagecatcher.data.local.dao.AvatarDao
import br.com.amd.githubimagecatcher.data.local.dao.EmojiDao
import br.com.amd.githubimagecatcher.data.local.database.ImageDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideEmojisDatabase(@ApplicationContext context: Context): ImageDatabase {
        return Room.databaseBuilder(
            context,
            ImageDatabase::class.java,
            "emojis.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEmojiDao(database: ImageDatabase): EmojiDao = database.getEmojiDao()

    @Singleton
    @Provides
    fun provideAvatarDao(database: ImageDatabase): AvatarDao = database.getAvatarDao()
}