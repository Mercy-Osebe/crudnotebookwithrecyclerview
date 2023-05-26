package com.example.crudnotebookwithrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        supportActionBar?.title="Add Note"
    }
}