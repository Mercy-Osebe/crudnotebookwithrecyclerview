package com.example.crudnotebookwithrecyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crudnotebookwithrecyclerview.R
import de.hdodenhof.circleimageview.CircleImageView

class CustomNoteAdapter(var titleArray: ArrayList<String>,
                        var descArray: ArrayList<String>,
                        var imageArray: ArrayList<Int>,
                        var context:Context):RecyclerView.Adapter<CustomNoteAdapter.NotesViewHolder>() {
    class NotesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var noteTitle: TextView =itemView.findViewById(R.id.title)
        var noteDesc:TextView=itemView.findViewById(R.id.desc)
        var noteImage: CircleImageView=itemView.findViewById(R.id.noteCardImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        //calls the card view design to be used in the view
        val view:View= LayoutInflater.from(parent.context).inflate(R.layout.add_note_card,parent,false)
        return NotesViewHolder(view)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        //        show data on the screen in recycler view.
        holder.noteTitle.text= titleArray[position]
        holder.noteDesc.text=descArray[position]
        holder.noteImage.setImageResource(imageArray[position])
    }

    override fun getItemCount(): Int {
        //        amount of data to be displayed in recycler view
        return descArray.size
    }
}