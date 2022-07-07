package com.example.note

import androidx.room.*

@Dao
interface noteDao {
    @Insert
    fun insertAll(vararg note: note)

    @Delete
    fun delete(note: note)

    @Update
    fun updateTodo(vararg note1: note)

    @Query("SELECT * FROM note")
    fun getAll(): List<note>

    @Query("SELECT * FROM note WHERE note1 LIKE :note1")
    fun findBynote1(note1: String): note
}