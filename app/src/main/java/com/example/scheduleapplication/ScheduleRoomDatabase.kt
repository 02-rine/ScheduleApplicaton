package com.example.scheduleapplication

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Schedule::class], version = 1)
abstract class ScheduleRoomDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: ScheduleRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ScheduleRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                // Room databaseを取得
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScheduleRoomDatabase::class.java,
                    "Word_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}