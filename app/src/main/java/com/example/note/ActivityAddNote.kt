package com.example.note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class ActivityAddNote : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val note1: EditText =findViewById(R.id.edt_note)
        val name: TextView =findViewById(R.id.textname)
        val btn_save: Button =findViewById(R.id.btn_edit)
        val btn_close: Button =findViewById(R.id.btn_close)

        btn_save.setOnClickListener {
            val db = AppDatabase(this)
            var n:note=note(note1.text.toString(),name.text.toString())
            db.noteDao().insertAll(n)
            Toast.makeText(this, "ثبت با موفقیت انجام شد", Toast.LENGTH_SHORT).show()

        }
    }
}