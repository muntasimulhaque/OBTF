package com.obtf.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey
    val id: Int = 1, // We'll only have one note
    val content: String,
    val lastModified: Date
) 