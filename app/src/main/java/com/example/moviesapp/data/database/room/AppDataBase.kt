package com.example.moviesapp.data.database.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(version = 1, entities = [MovieDbModel::class], exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun movieDao(): MovieDao

    companion object {

        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "movie_table.db"

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
                val db = Room.databaseBuilder(
                    application, AppDataBase::class.java, DB_NAME
                ).build()
                INSTANCE = db
                return db
            }
        }

    }

}