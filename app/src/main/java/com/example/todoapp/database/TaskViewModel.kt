package com.example.todoapp.database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(application: Application): AndroidViewModel(application) {
    val allTask: LiveData<List<TaskItem>>
    private val repository: TaskRepository

    init {
        val taskDao = TaskDB.getInstance(application).taskDao()
        repository = TaskRepository(taskDao)
        allTask = repository.allTask
    }

    fun inserTask(taskItem: TaskItem){
        viewModelScope.launch { repository.insertTask(taskItem) }
    }
    fun deleteTask(taskItem: TaskItem){
        viewModelScope.launch { repository.deleteTask(taskItem) }
    }
    fun updateTask(taskItem: TaskItem){
        viewModelScope.launch { repository.updateTask(taskItem) }
    }
    fun deleteAllTask(){
        viewModelScope.launch { repository.deleteAllTask() }
    }
}