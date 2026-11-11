package com.example.toyapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "children")
data class Child(
    @PrimaryKey
    val childCpf: String,
    val guardianCpf: String,
    val childName: String,
    val guardianEmail: String,
    val guardianPhone: String,
    val childAge: Int,
    val guardianName: String,
    val professionalName: String
)
