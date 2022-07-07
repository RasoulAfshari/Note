package com.example.note

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Activitylistnote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitylistnote)
        val btn_add:Button=findViewById(R.id.ac_listnote_add)
        btn_add.setOnClickListener {
            val intent: Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


    }

    override fun onResume() {
        super.onResume()
        val recycle:RecyclerView=findViewById(R.id.ac_note_list_recycle)
        val db =AppDatabase(this)
        var notes=db.noteDao().getAll()
        recycle.layoutManager=LinearLayoutManager(this)
        val adapter=AdapterNote(notes)
        recycle.adapter=adapter
    }
}