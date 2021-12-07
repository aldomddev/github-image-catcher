package br.com.amd.githubimagecatcher.di

import android.content.Context
import androidx.room.Room
import br.com.amd.githubimagecatcher.data.local.EmojiDao
import br.com.amd.githubimagecatcher.data.local.database.EmojisDatabase
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
    fun provideEmojisDatabase(@ApplicationContext context: Context): EmojisDatabase {
        return Room.databaseBuilder(
            context,
            EmojisDatabase::class.java,
            "emojis.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideEmojiDao(database: EmojisDatabase): EmojiDao = database.getEmojiDao()
}