package com.obtf.app

import android.app.Application
import androidx.room.Room
import com.obtf.app.data.AppDatabase

class OBTFApplication : Application() {
    lateinit var database: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "obtf_database"
        ).build()
    }
} 