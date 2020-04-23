package com.shafigh.recyclerviewapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val POSITION_NOT_SET = -1
const val STUDENT_POSITION_KEY = "STUDENT_POSITION"

class AddAndCreateStudentActivity : AppCompatActivity() {


    lateinit var nameTextView: EditText
    lateinit var classTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_and_create_student)

        nameTextView = findViewById(R.id.name_edit_text)
        classTextView = findViewById(R.id.class_edit_text)

        val saveButton = findViewById<Button>(R.id.save_button)

        //Check if intent has information
        val studentPosition = intent.getIntExtra(STUDENT_POSITION_KEY,POSITION_NOT_SET)
        if (studentPosition != POSITION_NOT_SET){
            saveButton.setOnClickListener{
                editStudent(studentPosition)
            }
            displayStudent(studentPosition)

        }else{
            saveButton.setOnClickListener{
                createNewStudent()
            }
        }/**/
    }

    private fun editStudent(position: Int){
        DataManager.students[position].name = nameTextView.text.toString()
        DataManager.students[position].className  = classTextView.text.toString()
        /**/
        finish()
    }

    private fun displayStudent(position : Int) {
        val student = DataManager.students[position]
        nameTextView.setText(student.name)
        classTextView.text = student.className
    }

    private fun createNewStudent () {
        val name = nameTextView.text.toString()
        val className = classTextView.text.toString()

        val student = Student(name,className)

        DataManager.students.add(student)
        finish()
    }
}
