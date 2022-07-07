package com.example.note

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class note(
    @PrimaryKey var note1: String
    , var name:String
    )
