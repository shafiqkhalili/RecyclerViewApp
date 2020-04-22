package com.shafigh.recyclerviewapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AddAndCreateStudentActivity : AppCompatActivity() {

    lateinit var nameTextView: EditText
    lateinit var classTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_and_create_student)

        nameTextView = findViewById(R.id.name_edit_text)
        classTextView = findViewById(R.id.class_edit_text)

        val saveButton = findViewById<Button>(R.id.save_button)
        saveButton.setOnClickListener{view ->
            createNewStudent()
        }
    }
    fun createNewStudent (): Unit {
        val name = nameTextView.text.toString()
        val className = classTextView.text.toString()

        val student = Student(name,className)

        DataManager.students.add(student)
        finish()
    }
}
