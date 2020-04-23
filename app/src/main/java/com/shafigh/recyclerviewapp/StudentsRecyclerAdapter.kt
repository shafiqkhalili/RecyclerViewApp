package com.shafigh.recyclerviewapp

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class StudentsRecyclerAdapter(private val context: Context,private val students: List<Student>) :
    RecyclerView.Adapter<StudentsRecyclerAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textName: TextView = itemView.findViewById<TextView>(R.id.text_name)
        val textClassName: TextView = itemView.findViewById<TextView>(R.id.text_className)
        private val deleteButton: ImageButton = itemView.findViewById(R.id.delete_button)
        val doneCheckBox: CheckBox = itemView.findViewById(R.id.done_checkbox)

        var studentPosition = 0
        init {
            //Add click listener when view is created
            itemView.setOnClickListener{
                val intent = Intent(context,AddAndCreateStudentActivity::class.java)
                intent.putExtra(STUDENT_POSITION_KEY,studentPosition)
                context.startActivity(intent)
            }
            deleteButton.setOnClickListener{view ->
                val dialogBuilder = AlertDialog.Builder(context)
                dialogBuilder.setTitle("Remove Student")
                    .setMessage("Do you want to remove student?")
                    .setPositiveButton("Remove",DialogInterface.OnClickListener{
                        dialog, id ->
                        removeStudent(studentPosition)
                        Snackbar.make(view,"Student removed", Snackbar.LENGTH_SHORT).show()
                    })
                    .setNegativeButton("Cancel",DialogInterface.OnClickListener{
                        dialog, id -> dialog.cancel()
                    })

                val alert = dialogBuilder.create()
                alert.show()
            }
            doneCheckBox.setOnClickListener{view ->
                Snackbar.make(view,"Done", Snackbar.LENGTH_SHORT).show()
                DataManager.students[studentPosition].done = doneCheckBox.isChecked
            }
        }
    }

    fun removeStudent(position: Int): Unit {
        DataManager.students.removeAt(position)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = layoutInflater.inflate(R.layout.student_list_view,parent, false)
        return  ViewHolder(itemView)
    }

    override fun getItemCount() = students.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.textName.text = student.name
        holder.textClassName.text = student.className
        holder.doneCheckBox.isChecked = student.done
        holder.studentPosition = position
    }
}