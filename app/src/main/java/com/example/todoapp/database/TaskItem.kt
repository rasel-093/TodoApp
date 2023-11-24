package com.example.todoapp.database

data class TaskItem(
    val id: Int? = null,
    var title: String,
    var details: String,
    var isCompleted: String = (false).toString(),
    var dueDate: String,
    var dueTime: String
){
    fun completeStatus(): Boolean = if(isCompleted == (false).toString()) false else true
}
