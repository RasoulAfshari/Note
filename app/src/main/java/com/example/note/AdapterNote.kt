package com.example.note

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class AdapterNote(private val notelist:List<note>):RecyclerView.Adapter<AdapterNote.ViewHolder>(){
    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val txt_number:TextView=itemView.findViewById(R.id.txt_number)
        val txt_note:TextView=itemView.findViewById(R.id.txt_note)
        val btn_edt:Button=itemView.findViewById(R.id.ac_item_note_bn_edt)
        val btn_del:Button=itemView.findViewById(R.id.ac_item_note_bn_del)
        val chkbax:CheckBox=itemView.findViewById(R.id.ac_item_note_chkbax)


    }
    lateinit var context:Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context=parent.context
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_note,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val mediaPlayer:MediaPlayer=MediaPlayer.create(context,R.raw.bikalam)
        holder.txt_note.text=notelist[position].note1
        holder.txt_number.text=notelist[position].name
        holder.btn_edt.setOnClickListener {
            Toast.makeText(context, "ورود ب ویرایش", Toast.LENGTH_SHORT).show()
            mediaPlayer.start()
            val intent:Intent=Intent(context,Activity_edit_note::class.java)
            intent.putExtra("number",notelist[position].name)
            intent.putExtra("note1",notelist[position].note1)
            context.startActivity(intent)

        }
        holder.btn_del.setOnClickListener {
            mediaPlayer.start()

            val db = AppDatabase(context)
            var existnote = db.noteDao().findBynote1(notelist[position].note1)
            if(existnote==null){
                Toast.makeText(context, "not found", Toast.LENGTH_SHORT).show()
            }
            else{
                val builde=AlertDialog.Builder(context)
                builde.setTitle("Error")
                builde.setIcon(android.R.drawable.ic_dialog_info)
                builde.setMessage("آیا از حذف آن مطمئن هستین؟")
                builde.setPositiveButton("بله"){dialog,which->
                    db.noteDao().delete(existnote)
                    Toast.makeText(context, "حذف شد", Toast.LENGTH_SHORT).show()
                    (context as Activitylistnote).recreate()
                }
                builde.setNegativeButton("خیر"){dialog,which->
                    Toast.makeText(context, "لغو شد", Toast.LENGTH_SHORT).show()
                }
                builde.show()


            }
        }
        holder.chkbax.setOnClickListener {
            mediaPlayer.start()
            if(holder.chkbax.isChecked){
                holder.btn_edt.setBackgroundColor(Color.parseColor("green"))
                holder.btn_del.setBackgroundColor(Color.parseColor("green"))
            }
            else{
                holder.btn_edt.setBackgroundColor(Color.parseColor("blue"))
                holder.btn_del.setBackgroundColor(Color.parseColor("blue"))
                holder.btn_edt.setTextColor(Color.parseColor("white"))
                holder.btn_del.setTextColor(Color.parseColor("white"))
            }
        }

    }

    override fun getItemCount(): Int {
        return notelist.size
    }

}