package com.example.note

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class user(
    @PrimaryKey var note1: String
    , var name:String
)
