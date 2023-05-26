package com.example.crudnotebookwithrecyclerview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.crudnotebookwithrecyclerview.adapters.CustomNoteAdapter

class MainActivity : AppCompatActivity() {

    var titleArray= arrayListOf<String>("One","Two")
    var imageArray= arrayListOf<Int>(R.drawable.me,R.drawable.me)
    var descArray= arrayListOf<String>("This is note one","This is note two")
    lateinit var notesRecyclerView:RecyclerView
//    get data from AddNoteActivity
    lateinit var addActivityResultLauncher:ActivityResultLauncher<Intent>

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.title ="All Notes"
        notesRecyclerView=findViewById(R.id.notesRecyclerView)
        notesRecyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
        notesRecyclerView.adapter=CustomNoteAdapter(titleArray,descArray,imageArray,this)

        getResponseDataFromAddNoteActivity()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if(item.itemId==R.id.addNote){
            val intent=Intent(this,AddNoteActivity::class.java)
            addActivityResultLauncher.launch(intent)

        }
        else if(item.itemId==R.id.deleteNotes){
            // TODO: write delete notes functionalities
        }
        return false

    }
   private fun getResponseDataFromAddNoteActivity(){
       addActivityResultLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
           ActivityResultCallback {
           resultAddNote->
           val resCode=resultAddNote.resultCode
           val data=resultAddNote.data
           if(resCode== RESULT_OK && data!=null){
               val title=data.getStringExtra("title")
               val desc=data.getStringExtra("desc")
              if(title=="" && desc!=""){
                   titleArray.add("No title")
                   imageArray.add(R.drawable.me)
                   if (desc != null) {
                       descArray.add(desc)
                   }
                   notesRecyclerView.adapter=CustomNoteAdapter(titleArray,descArray,imageArray,this)

               }else if(title!="" && desc==""){
                   if (title != null) {
                       titleArray.add(title)
                   }
                   imageArray.add(R.drawable.me)
                   descArray.add("No desc")
                   notesRecyclerView.adapter=CustomNoteAdapter(titleArray,descArray,imageArray,this)
               }
               else  if(title=="" ||desc==""){
                  titleArray.add("No title")
                  descArray.add("No desc")
                  imageArray.add(R.drawable.me)
                  notesRecyclerView.adapter=CustomNoteAdapter(titleArray,descArray,imageArray,this)
              }
               else{
                   imageArray.add(R.drawable.me)
                   if (title != null) {
                       titleArray.add(title)
                   }
                   if (desc != null) {
                       descArray.add(desc)
                   }
                   notesRecyclerView.adapter=CustomNoteAdapter(titleArray,descArray,imageArray,this)
               }
           }
       })

    }
}