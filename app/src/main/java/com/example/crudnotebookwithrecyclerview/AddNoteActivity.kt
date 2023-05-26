package com.example.crudnotebookwithrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddNoteActivity : AppCompatActivity() {
    lateinit var titleEditText:EditText
    lateinit var descEditText: EditText
    lateinit var cancelBtn:Button
    lateinit var addNoteBtn:Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.title="Add Note"

        titleEditText=findViewById(R.id.titleNoteEditText)
        descEditText=findViewById(R.id.descNoteEditText)
        cancelBtn=findViewById(R.id.cancelBtn)
        addNoteBtn=findViewById(R.id.addNoteBtn)

        addNoteBtn.setOnClickListener {
            addNote()
        }
        cancelBtn.setOnClickListener {
            cancelNote()
        }
    }
    private fun addNote(){
        val title=titleEditText.text.toString()
        val desc=descEditText.text.toString()
        val intent=Intent()
        if(title=="" && desc==""){
            Toast.makeText(this,"You need at least one input",Toast.LENGTH_SHORT).show()
        }
        else{
            intent.putExtra("title",title)
            intent.putExtra("desc",desc)
            setResult(RESULT_OK,intent)
            finish()
        }

    }
    private fun cancelNote(){
        Toast.makeText(this,"Note cancelled",Toast.LENGTH_SHORT).show()
        finish()


    }
}