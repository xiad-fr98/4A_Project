package com.example.projetandroid4a.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.projetandroid4a.data.local.models.DatabaseDao
import com.example.projetandroid4a.data.local.models.UserLocal

@Database(entities = arrayOf(
    UserLocal::class
), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
}