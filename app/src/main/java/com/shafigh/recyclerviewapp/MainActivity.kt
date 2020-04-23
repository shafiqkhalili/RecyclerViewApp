package com.shafigh.recyclerviewapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.studentsList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = StudentsRecyclerAdapter(this,DataManager.students)
        
        val fab = findViewById<View>(R.id.floatingActionButton)
        fab.setOnClickListener{
            //Change activity
            val intent = Intent(this,AddAndCreateStudentActivity::class.java)
            startActivity(intent)
        }
    }
    //Refresh Adapter
    override fun onResume() {
        super.onResume()
        //Use on small data, to refresh whole data
        //On large data, be specific on what is changed
        recyclerView.adapter?.notifyDataSetChanged()
    }
}
