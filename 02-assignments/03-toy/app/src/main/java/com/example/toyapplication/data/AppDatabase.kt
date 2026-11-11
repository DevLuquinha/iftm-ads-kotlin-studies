package com.example.toyapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Child::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun childDao(): ChildDao
}