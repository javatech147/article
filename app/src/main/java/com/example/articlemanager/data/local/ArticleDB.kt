package com.example.articlemanager.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ArticleEntity::class], version = 1)
abstract class ArticleDB : RoomDatabase() {

    abstract fun getDao(): ArticleDao

    companion object {
        private var INSTANCE: ArticleDB? = null

        fun getInstance(context: Context): ArticleDB {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context = context.applicationContext,
                    klass = ArticleDB::class.java,
                    name = "article_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}
