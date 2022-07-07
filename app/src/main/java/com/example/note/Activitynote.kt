package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class Activitynote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_activitynote)

//        val db = AppDatabase(this)
//        var n:note=note("انجام پروژه2","rasoul")
//        db.noteDao().insertAll(n)
//        var ns=db.noteDao().getAll()
//        Toast.makeText(this,ns.size.toString(), Toast.LENGTH_SHORT).show()


    }
}