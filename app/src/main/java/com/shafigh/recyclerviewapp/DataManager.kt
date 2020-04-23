package com.shafigh.recyclerviewapp

object DataManager {
    val students = mutableListOf<Student>()

    init {
        createMockData()
    }

    fun createMockData(){
        var student = Student("Shafigh", "MAP19",true)
        students.add(student)
        student = Student("Alessio", "MAP19")
        students.add(student)
        student = Student("Alexander", "MAP19")
        students.add(student)
        student = Student("Johannes", "MAP19")
        students.add(student)
        student = Student("Emil", "MAP19")
        students.add(student)
    }
}