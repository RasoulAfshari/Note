package com.example.note

import android.app.AlertDialog
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Activity_edit_note : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)

        val note1:String=intent.getStringExtra("note1")!!
        Toast.makeText(this, note1, Toast.LENGTH_SHORT).show()
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.bikalam)
        val edt_note1:EditText=findViewById(R.id.edt_note2)
        val number:EditText=findViewById(R.id.edt_note1)
        val btn_edit:Button=findViewById(R.id.btn_edit)
        val btn_close:Button=findViewById(R.id.btn_close)
        val db = AppDatabase(this)
        var existnote = db.noteDao().findBynote1(note1)
        if(existnote==null){
            Toast.makeText(this, "error note not found", Toast.LENGTH_SHORT).show()
        }
        else{

            edt_note1.setText(existnote.note1)
            number.setText(existnote.name)

        }
        btn_edit.setOnClickListener {
            mediaPlayer.start()
            val builde= AlertDialog.Builder(this)
            builde.setTitle("Error")
            builde.setIcon(android.R.drawable.ic_dialog_info)
            builde.setMessage("آیا از ویرایش آن مطمئن هستین؟")
            builde.setPositiveButton("بله"){dialog,which->

                existnote.name = number.text.toString()
                db.noteDao().updateTodo(existnote)

                Toast.makeText(this, "ویرایش شد", Toast.LENGTH_SHORT).show()

            }
            builde.setNegativeButton("خیر"){dialog,which->
                Toast.makeText(this, "لغو شد", Toast.LENGTH_SHORT).show()
            }
            builde.show()



        }
        btn_close.setOnClickListener {
            mediaPlayer.start()
            val intent: Intent = Intent(this,Activitylistnote::class.java)
            startActivity(intent)
        }


    }
}