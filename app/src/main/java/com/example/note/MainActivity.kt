package com.example.note

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val note1:EditText=findViewById(R.id.edt_note)
        val number:EditText=findViewById(R.id.edt_name)
        val btn_save:Button=findViewById(R.id.btn_edit)
        val btn_close:Button=findViewById(R.id.btn_close)
        val mediaPlayer: MediaPlayer = MediaPlayer.create(this,R.raw.bikalam)

        btn_save.setOnClickListener {
            mediaPlayer.start()
            if(note1.text.toString()=="" || number.text.toString()==""){
                Toast.makeText(this, "فیلد ها نباید خالی باشد", Toast.LENGTH_SHORT).show()
            }
            else{
                val db = AppDatabase(this)
                var existnote = db.noteDao().findBynote1(note1.text.toString())
                if(existnote==null){
                    var n:note=note(note1.text.toString(),number.text.toString())
                    db.noteDao().insertAll(n)
                    Toast.makeText(this, "ثبت با موفقیت انجام شد", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(this, "تکراری است", Toast.LENGTH_SHORT).show()
                }
            }
        }
        btn_close.setOnClickListener {
            mediaPlayer.start()
            val intent:Intent= Intent(this,Activitylistnote::class.java)
            startActivity(intent)
        }

    }
}