package com.example.todoapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class TaskItem(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo("title")  var title: String,
    @ColumnInfo("details")  var details: String,
    @ColumnInfo("status")  var isCompleted: String = (false).toString(),
    @ColumnInfo("deadlinedate")  var deadLineDate: String,
    @ColumnInfo("deadlinetime")   var deadLineTime: String
){
    fun completeStatus(): Boolean = if(isCompleted == (false).toString()) false else true
}
