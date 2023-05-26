package com.example.crudnotebookwithrecyclerview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudnotebookwithrecyclerview.adapters.CustomNoteAdapter

class MainActivity : AppCompatActivity() {

    var titleArray= arrayListOf<String>("One","Two")
    var imageArray= arrayListOf<Int>(R.drawable.me,R.drawable.me)
    var descArray= arrayListOf<String>("This is note one","This is note two")
    lateinit var notesRecyclerView:RecyclerView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title ="All Notes"
        notesRecyclerView=findViewById(R.id.notesRecyclerView)
        notesRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        notesRecyclerView.adapter=CustomNoteAdapter(titleArray,descArray,imageArray,this)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if(item.itemId==R.id.addNote){
            TODO("write add note functionality")

        }
        else if(item.itemId==R.id.deleteNotes){
            // TODO: write delete notes functionalities
        }
        return false

    }
}